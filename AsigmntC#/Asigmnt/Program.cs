using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Control;
using MainView;
using Models;

namespace FootballManager
{
    class Program
    {
        private ClubManager clbMng;
        private View view;
        private MatchManager mtchMng;

        static void Main(string[] args)
        {
            Console.SetWindowSize(Console.LargestWindowWidth, Console.LargestWindowHeight);
          //  Console.SetWindowPosition(10, 10);
            Program prg = new Program();
            prg.clbMng = new ClubManager();
            prg.view = new View();
            prg.mtchMng = new MatchManager();

            prg.showMainMenu();
        }

        private void showMainMenu()
        {
            int i;
            bool check = true;
            while (true)
            {
                view.showMainMenu();
                do
                {
                    i = view.getInt();
                    switch (i)
                    {
                        case 0:
                            Environment.Exit(0);
                            check = false;
                            break;
                        case 1:
                            clbManage();
                            check = false;
                            break;
                        case 2:
                            matchManage();
                            check = false;
                            break;
                        case 3:
                            editMatchScore();
                            check = false;
                            break;
                        case 4:
                            showStats();
                            check = false;
                            break;
                        default:
                            break;
                    }
                    if (check)
                        view.printChoice();
                } while (check);
            }
        }

        //Clubs

        private void clbManage()
        {
            bool loop = true;
            int i;
            bool check = true;
            while (loop)
            {
                view.showClubMenu();
                do
                {
                    i = view.getInt();
                    switch (i)
                    {
                        case 0:
                            check = false;
                            loop = false;
                            break;
                        case 1:
                            viewClubList();
                            check = false;
                            loop = false;
                            break;
                        case 2:
                            editClub();
                            check = false;
                            break;
                        case 3:
                            createClub();
                            check = false;
                            break;
                        default:
                            break;
                    }
                    if (check)
                        view.printChoice();
                } while (check);
            }
        }

        private void editClub()
        {
            do{
                view.editClubHeading();
                int id = view.getClubId();
                int i = clbMng.getClubIndexById(id);
                if(i != -1){
                    string name = view.getClubName();
                    string couch = view.getClubCouch();
                    if (view.confirmEdit())
                        clbMng.editClub(i, name, couch);
                }
                else
                {
                    view.clubNotFoundMsg(id);
                }
            }
            while (view.confirmContinue());
        }

        private void createClub()
        {
            int id;
            int i;
            do
            {
                view.createClubHeading();
                do{
                    id = view.getClubId();
                    i = clbMng.getClubIndexById(id);
                    if (i != -1)
                        view.clubExistMsg(id);
                }while(i != -1);
                clbMng.createClub(id, view.getClubName(), view.getClubCouch());
            } 
            while (view.confirmContinue());
        }

        private void viewClubList()
        {
            int i;
            bool check = true;
            view.showClubListHeading();
            for ( i = 0; i < clbMng.Clubs.Count; i++ )
            {
                view.showClubId( clbMng.getClub(i).Id );
                view.showClubName( clbMng.getClub(i).Name );
                view.showClubCouch( clbMng.getClub(i).Couch );
                view.insertEmptyLine();
            }
            view.showClubListFooter();
            do{
                i = view.getInt();
                switch(i){
                    case 0:
                        check = false;
                        break;
                    case 1:
                        viewClubList();
                        check = false;
                        break;
                    case 2:
                        editClub();
                        check = false;
                        break;
                    case 3:
                        createClub();
                        check = false;
                        break;
                    case 4:
                        clbMng.sortClubsById();
                        viewClubList();
                        check = false;
                        break;
                    case 5:
                        clbMng.sortClubsByName();
                        viewClubList();
                        check = false;
                        break;
                    default:
                        break;
                }
                if (check)
                    view.printChoice();
            }while(check);
        }

        //End Clubs
        //Matches

        private void matchManage()
        {
            bool loop = true;
            int i;
            bool check = true;
            while (loop)
            {
                view.showMatchMenu();
                do
                {
                    i = view.getInt();
                    switch (i)
                    {
                        case 0:
                            check = false;
                            loop = false;
                            break;
                        case 1:
                            showMatchList();
                            check = false;
                            break;
                        case 2:
                            editMatch();
                            check = false;
                            break;
                        case 3:
                            createMatch();
                            check = false;
                            break;
                        default:
                            break;
                    }
                    if (check)
                        view.printChoice();
                } while (check);
            }
        }

        private void createMatch()
        {
            do{
                view.createMatchHeading();
                int id1 = view.getClubId(1);
                int i1 = clbMng.getClubIndexById(id1);
                int id2 = view.getClubId(2);
                int i2 = clbMng.getClubIndexById(id2);
                if(i1 == -1){
                    view.clubNotFoundMsg(id1);
                }
                else if (i2 == -1)
                {
                    view.clubNotFoundMsg(id2);
                }
                else
                {
                    mtchMng.createMatch ( id1, id2, view.getMatchTime() ,view.getMatchLocation() );
                }
            }
            while (view.confirmContinue());
        }

        private void editMatch()
        {
            int i;
            string time;
            string location;
            do
            {
                view.editMatchHeading();
                i = view.getMatchIndex();
                if (i >= 0 && i < mtchMng.Matches.Count)
                {
                    time = view.getMatchTime();
                    location = view.getMatchLocation();
                    if (view.confirmEdit())
                        mtchMng.editMatch(i, time, location);
                }
                else
                {
                    view.showMatchNotFoundMsg();
                }
            } while (view.confirmContinue());
        }

        private void showMatchList()
        {
            view.showMatchListHeading();
            for (int i = 0; i < mtchMng.Matches.Count; i++)
            {
                view.showMatchId(i);
                if (mtchMng.Matches[i].Club1_score == -1)
                {
                    view.showClub(
                        clbMng.Clubs[clbMng.getClubIndexById(mtchMng.Matches[i].Club1Id)].Name
                    );
                    view.showClub(
                        clbMng.Clubs[clbMng.getClubIndexById(mtchMng.Matches[i].Club2Id)].Name
                    );
                }
                else
                {
                    view.showClub(
                        clbMng.Clubs[clbMng.getClubIndexById(mtchMng.Matches[i].Club1Id)].Name,
                        mtchMng.Matches[i].Club1_score
                    );
                    view.showClub(
                        clbMng.Clubs[clbMng.getClubIndexById(mtchMng.Matches[i].Club2Id)].Name,
                        mtchMng.Matches[i].Club2_score
                    );
                }
                view.showMathInfo(mtchMng.Matches[i].Time);
                view.showMathInfo(mtchMng.Matches[i].Location);
                view.insertEmptyLine();
            }
            view.showTableFooter();
        }

        private void editMatchScore()
        {
            int i;
            int score1;
            int score2;
            int clubId;
            FootballClub club1;
            FootballClub club2;
            showMatchList();
            view.editScoreHeading();
            do
            {
                view.editMatchHeading();
                i = view.getMatchIndex();
                if (i >= 0 && i < mtchMng.Matches.Count)
                {
                    clubId = mtchMng.Matches[i].Club1Id;
                    club1 = clbMng.getClubById(clubId);
                    score1 = view.getClubScore(club1.Name);

                    clubId = mtchMng.Matches[i].Club2Id;
                    club2 = clbMng.getClubById(clubId);
                    score2 = view.getClubScore(club2.Name);

                    if (view.confirmEdit())
                    {
                        mtchMng.editScore(i, score1, score2);
                        club1.MatchTotal++;
                        club2.MatchTotal++;
                        if (score1 > score2)
                            club1.MatchWon++;
                        else if (score1 < score2)
                            club2.MatchWon++;
                        else
                        {
                            club1.MatchDraw++;
                            club2.MatchDraw++;
                        }
                    }
                }
                else
                {
                    view.showMatchNotFoundMsg();
                }
            } while (view.confirmContinue()); 
        }

        private void showStats()
        {
            int i;
            FootballClub club;
            view.showStatsHeading();
            for (i = 0; i < clbMng.Clubs.Count; i++)
            {
                club = clbMng.getClub(i);
                view.showClubId(club.Id);
                view.showClubName(club.Name);
                view.showStat(club.MatchTotal);
                view.showStat(club.MatchWon);
                view.showStat(club.MatchDraw);
                view.showStat(club.MatchTotal - (club.MatchDraw + club.MatchWon));
                view.showStat(scoreCal(club.MatchWon, club.MatchDraw));
                view.insertEmptyLine();
            }
            view.showTableFooter();
        }

        private int scoreCal(int won, int draw)
        {
            return won * 3 + draw * 1;
        }

        //End Matches
    }
}
