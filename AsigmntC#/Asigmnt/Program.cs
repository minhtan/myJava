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
            view.showMainMenu();
            do{
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
                    default:
                        break;
                }
                if (check)
                    view.printChoice();
            }while(check);
        }

        //Clubs

        private void clbManage()
        {
            int i;
            bool check = true;
            view.showClubMenu();
            do{
                i = view.getInt();
                switch(i){
                    case 0:
                        showMainMenu();
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
                    default:
                        break;
                }
                if (check)
                    view.printChoice();
            }while(check);
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
            clbManage();
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
            clbManage();
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
                        showMainMenu();
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
            int i;
            bool check = true;
            view.showMatchMenu();
            do{
                i = view.getInt();
                switch(i){
                    case 0:
                        showMainMenu();
                        check = false;
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
            }while(check);
        }

        public void createMatch()
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
            matchManage();
        }

        public void editMatch()
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
            matchManage();
        }

        public void showMatchList()
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
            view.showMatchListFooter();
            matchManage();
        }

        //End Matches
    }
}
