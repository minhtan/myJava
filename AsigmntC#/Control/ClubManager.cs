using System;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Models;
using System.Collections;
using System.Collections.Generic;

namespace Control
{
    public class ClubManager
    {
        private List<FootballClub> clubs;

        public ClubManager()
        {
            clubs = new List<FootballClub>();
        }

        public List<FootballClub> Clubs{
            get {return clubs;}
        }

        public void createClub(int id, string name, string couch)
        {
            clubs.Add(new FootballClub(id, name, couch));
        }

        public FootballClub getClub(int i)
        {
            return clubs[i];
        }

        public void editClub(int i, string name, string couch){
            clubs[i].Name = name;
            clubs[i].Couch = couch;
        }

        public int getClubIndexById(int id)
        {
            for (int i=0; i < clubs.Count; i++)
            {
                if (clubs[i].Id == id)
                    return i;
            }
            return -1;
        }

        public FootballClub getClubById(int id)
        {
            int i = getClubIndexById(id);
            if (i != -1)
                return clubs[i];
            else
                return null;
        }

        public void sortClubsByName()
        {
            clubs = clubs.OrderBy(club => club.Name).ToList();
        }

        public void sortClubsById()
        {
            clubs = clubs.OrderBy(club => club.Id).ToList();
        }
    }
}
