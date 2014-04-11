using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace MainView
{
    public class View
    {
        public void showMainMenu()
        {
            insertEmptyLine();
            Console.WriteLine("---------------Chao mung den voi V-league---------------");
            insertEmptyLine();
            insertLine();
            insertEmptyLine();
            Console.WriteLine("- 1. Quan ly danh sach doi bong");
            Console.WriteLine("- 2. Quan ly lich thi dau");
            Console.WriteLine("- 3. Quan ly ket qua thi dau");
            Console.WriteLine("- 4. Thong ke");
            Console.WriteLine("- 0. Thoat");
            printChoice();
        }

        //Clubs

        public void showClubMenu()
        {
            insertEmptyLine();
            insertLine();
            insertEmptyLine();
            Console.WriteLine("- 1. Xem danh sach doi bong");
            Console.WriteLine("- 2. Cap nhat doi bong");
            Console.WriteLine("- 3. Them moi mot doi bong");
            Console.WriteLine("- 0. Tro ve menu chinh");
            printChoice();
        }

        public void createClubHeading()
        {
            insertEmptyLine();
            Console.WriteLine("=================Them moi mot doi bong==================");
            insertEmptyLine();            
        }

        public int getClubId()
        {
            Console.Write("- Nhap ma doi: ");
            return this.getInt();
        }

        public int getClubId(int i)
        {
            Console.Write("- Nhap ma doi {0}: ", i);
            return this.getInt();
        }

        public string getClubName()
        {
            Console.Write("- Nhap ten doi: ");
            return getString();
        }

        public string getClubCouch()
        {
            Console.Write("- Nhap ten hlv: ");
            return getString();
        }

        public void showClubListHeading()
        {
            insertEmptyLine();
            insertLine();
            insertEmptyLine();
            Console.WriteLine("| Ma doi         | Ten Doi               | HLV         |");
            insertEmptyLine();
            insertLine();
            insertEmptyLine();
        }

        public void showClubListFooter()
        {
            insertEmptyLine();
            insertLine();
            insertEmptyLine();
            insertLine();
            insertEmptyLine();
            Console.WriteLine("- 1. Xem danh sach doi bong");
            Console.WriteLine("- 2. Cap nhat doi bong");
            Console.WriteLine("- 3. Them moi mot doi bong");
            Console.WriteLine("- 4. Xem danh sach doi bong theo ma doi");
            Console.WriteLine("- 5. Xem danh sach doi bong theo ten doi");
            Console.WriteLine("- 0. Tro ve menu chinh");
            printChoice();
        }

        public void editClubHeading()
        {
            insertEmptyLine();
            Console.WriteLine("==============Cap nhat thong tin doi bong===============");
            insertEmptyLine();
        }

        public void showClubId(int id){
            Console.Write("| {0, -15}", id);
        }

        public void showClubName(string name)
        {
            Console.Write("| {0, -22}", name);
        }

        public void showClubCouch(string couch)
        {
            Console.Write("| {0, -12}|", couch);
        }

        public void clubNotFoundMsg(int id)
        {
            Console.WriteLine("Khong tim thay clb voi ma so: {0}", id);
        }

        public void clubExistMsg(int id)
        {
            Console.WriteLine("Clb voi ma so: {0} da ton tai", id);
        }

        //End Clubs
        //Matches

        public void showMatchMenu()
        {
            insertEmptyLine();
            insertLine();
            insertEmptyLine();
            Console.WriteLine("- 1. Xem lich thi dau");
            Console.WriteLine("- 2. Cap nhat lich thi dau");
            Console.WriteLine("- 3. Them moi lich thi dau");
            Console.WriteLine("- 0. Tro ve menu chinh");
            printChoice();
        }

        public void createMatchHeading()
        {
            insertEmptyLine();
            Console.WriteLine("=================Them moi lich thi dau==================");
            insertEmptyLine();
        }

        public void showMatchListHeading()
        {
            insertEmptyLine();
            Console.WriteLine("=======================================Lich thi dau=======================================");
            insertEmptyLine();
            Console.WriteLine("| Stt | Doi 1              | Doi 2              | Thoi gian          | Dia diem           ");
            insertEmptyLine();
        }

        public void showTableFooter()
        {
            insertEmptyLine();
            insertLine();
            insertEmptyLine();
        }

        public void showMatchId(int i)
        {
            Console.Write("| {0, -4}", i);
        }

        public void showClub(string name, int score)
        {
            Console.Write("| {0, -16}{1, 2} ", name, score);
        }

        public void showClub(string name)
        {
            Console.Write("| {0, -19}", name);
        }

        public void showMathInfo(string txt)
        {
            Console.Write("| {0, -19}", txt);
        }

        public string getMatchLocation()
        {
            Console.Write("- Nhap dia diem: ");
            return getString();
        }

        public string getMatchTime()
        {
            Console.Write("- Nhap thoi gian: ");
            return getString();
        }

        public int getClubScore(string name)
        {
            Console.Write("- Nhap ket qua doi {0} : ", name);
            return getInt();
        }

        public void editMatchHeading()
        {
            insertEmptyLine();
            Console.WriteLine("============Cap nhat thong tin lich dau==========");
            insertEmptyLine();
        }

        public int getMatchIndex()
        {
            Console.Write("- Nhap stt lich dau: ");
            return getInt();
        }

        public void showMatchNotFoundMsg()
        {
            Console.WriteLine("Khong tim thay lich dau");
        }

        public void editScoreHeading()
        {
            insertEmptyLine();
            Console.WriteLine("============Cap nhat ket qua tran dau============");
            insertEmptyLine();
        }

        public void showStatsHeading()
        {
            insertEmptyLine();
            Console.WriteLine("====================================Thong ke===========================================");
            insertEmptyLine();
            Console.WriteLine("| Ma doi         | Ten Doi               | Tran   | Thang  | Hoa    | Thua   | Diem    ");
            insertEmptyLine();
        
        }

        public void showStat(int i)
        {
            Console.Write("| {0, -7}", i);
        }

        //End Matches
        //General

        public bool confirm()
        {
            string confirm = null;
            while(confirm == null || !Regex.Match(confirm, @"([YNyn])").Success){
                confirm = getString();
                if(!Regex.Match(confirm, @"([YNyn])").Success)
                    Console.Write("Nhap 'Y' hoac 'N': ");
            }
            if (Regex.Match(confirm, @"([Yy])").Success)
                return true;
            else
                return false;
        }

        public bool confirmContinue()
        {
            Console.Write("- Tiep tuc? (Y/N) ");
            return confirm();
        }

        public bool confirmEdit(){
            Console.Write("- Cap nhat? (Y/N) ");
            return confirm();
        }

        public int getInt()
        {
            bool check = false;
            do{
                try
                {
                    return Convert.ToInt32(Console.ReadLine());
                }
                catch (FormatException e)
                {
                    Console.Write("Hay nhap vao 1 so: ");
                    check = true;
                }
            } while (check);
            return -1;
        }

        public string getString()
        {
            return Console.ReadLine();
        }

        public void insertEmptyLine()
        {
            Console.WriteLine();
        }

        public void insertLine()
        {
            Console.WriteLine("========================================================");
        }

        public void printChoice()
        {
            Console.Write("#Chon: ");
        }

        //End General
    }
}
