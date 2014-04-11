using System;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Models;
using System.Collections.Generic;

namespace Control
{
    public class MatchManager
    {
        private List<Match> matches;

        public MatchManager()
        {
            matches = new List<Match>();
        }

        public List<Match> Matches
        {
            get { return matches; }
        }

        public void createMatch(int club1Id, int club2Id, string time, string location)
        {
            matches.Add(new Match(club1Id, club2Id, time, location));
        }

        public void editMatch(int i, string time, string location)
        {
            matches[i].Time = time;
            matches[i].Location = location;
        }

        public Match getMatch(int i)
        {
            return matches[i];
        }

        public void editScore(int i, int club1Score, int club2Score)
        {
            matches[i].Club1_score = club1Score;
            matches[i].Club2_score = club2Score;
        }
    }
}
