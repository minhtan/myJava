using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class Match
    {
        private int club1Id;
        private int club2Id;
        private string time;
        private string location;
        private int club1_score;
        private int club2_score;

        public Match(int club1Id, int club2Id, string time, string location)
        {
            Club1Id = club1Id;
            Club2Id = club2Id;
            Time = time;
            Location = location;
            Club1_score = -1;
            Club2_score = -1;
        }

        public int Club1Id
        {
            get { return club1Id; }
            set { club1Id = value; }
        }

        public int Club2Id
        {
            get { return club2Id; }
            set { club2Id = value; }
        }

        public int Club1_score
        {
            get { return club1_score; }
            set { club1_score = value; }
        }

        public int Club2_score
        {
            get { return club2_score; }
            set { club2_score = value; }
        }

        public string Time
        {
            get { return time; }
            set { time = value; }
        }

        public string Location
        {
            get { return location; }
            set { location = value; }
        }
    }
}
