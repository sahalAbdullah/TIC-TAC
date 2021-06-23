# TIC-TAC
TIC TAC TOE implemented using Minmax Algorithm
Abstract:
       This game is about multi-agent game in which first move is going to make by player and second game is going to play by computer in the way that user cannot win or at least draw the match. Mini Max and Alpha-Beta pruning method use in this to make a move and finish the game. 
Introduction:
        In this project I implemented TIC TAC TOE game. In which there is 3x3 board is given in which first move is placed by user and then further move is approach by Mini Max or Alpha Beta pruning method and so on turn by turn until the game is finished.
       The key to the Minimax algorithm is a back and forth between the two players, where the player whose "turn it is" desires to pick the move with the maximum score. In turn, the scores for each of the available moves are determined by the opposing player deciding which of its available moves has the minimum score. And the score for the opposing players moves are again determined by the turn-taking player trying to maximize its score and so on all the way down the move tree to an end state.
 
Figure 1
       This proposed work presents an intuitive method to implement the Alpha-Beta pruning followed by minimax algorithm, a back-pedal algorithm that is used in option choosing from combinations of several alternatives, to achieve better understating of how Artificial Intelligence (AI) works. By combining complex algorithms with regular paper-and-pencil game Tic-tac-toe leads toward a clear and intuitive learning. Such basic games are deeply melted in our instincts thus the concept of pruning can easily be approached. Minimax is used in game playing to find the best efficient move for a player assuming that the rival player will play to win too. Later Alpha-Beta pruning will equalize the minimax algorithm. It returns the same move but it removes all the branches that will not be affecting the final part of the game. For output, a standard grid of nine squares (3x3) is used, consisting of 3 rows and 3 columns. However, this grid can further be extended to 4x4 or 5x5 to increase the complexity of the algorithm.
 Time Complexity:
Mini Max:
MINIMAX algorithm performs complete depth first exploration of the game tree. If the maximum depth of the tree is m (9 for Tic-Tac-Toe).The time complexity of MINIMAX algorithm is O(bm) and the space complexity is O(m).

     Alpha-Beta Pruning:
		O(b^(d/2)) correspond to the best case time complexity of alpha-beta pruning. Explanation: With an (average or constant) branching factor of b, and a search depth of d plies.
Working:
	GUI Board is called by the main class and GUI class present the board in GUI then the move selected by the user by clicking on it and the board class call minimax method and the move by minimax by GUI.
