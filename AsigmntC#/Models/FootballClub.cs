using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class FootballClub
    {
        private int matchTotal;
        private int matchWon;
        private int id;
        private string name;
        private string couch;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public string Couch
        {
            get { return couch; }
            set { couch = value; }
        }

        public int MatchTotal
        {
            get { return matchTotal; }
            set { matchTotal = value; }
        }

        public int MatchWon
        {
            get { return matchWon; }
            set { matchWon = value; }
        }

        public FootballClub(int id, string name, string couch){
            Id = id;
            Name = name;
            Couch = couch;
        }
    }
}
