# Graphs
Java program that reads one of the associated files. Each file is a map for a dungeon, 
and the goal is to determine whether the dungeon hides a heart container. 
Note that you lose 1 health for every step taken. If you must 
walk further than 100 steps, you will not be able to get the heart container without taking some potions.
Potions restore 50 health each.

The input file is a text file that contains either a comment (beginning with #) or data for a particular vertex.
The first token represents the name of a room in the dungeon. After that, each pair of tokens represents a connected room and the steps it will
take to travel to that room. (A room can be connected to up to 32 other rooms). 

Every dungeon entrance is named A. When there are multiple connected rooms, they are explored
in alphabetic order. The room labeled X contains a heart container. Not all rooms are connected.

The program prints out a message stating whether there is a heart container in a room, along with the path that
should be taken to get it, and the number of steps it takes to get there. 
If it requires potions, the program also states how many potions would be required. If you cannot get a heart container in that dungeon, the program simply says so.
