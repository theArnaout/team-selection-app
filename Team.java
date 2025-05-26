//  Team.java
//
//  Mohamad Arnaout
//  T00765395
//  COMP 1231 Assignment 4
//  Thursday, April 24, 2025.
//
//  This is a generic class that manages a team of members using
//  ArrayList. It implements Iterable to allow iteration over the
//  members.
//*********************************************************************

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Team<T> implements Iterable<T> {

    // Stores the team members
    private final ArrayList<T> list;

    // Initialize an empty ArrayList
    public Team() {
        list = new ArrayList<>();
    }

    // Adds a member to the team
    public void addToTeam(T member) {
        list.add(member);
    }

    // Removes the last member who joined the team
    public void removeFromTeam() {
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }

    // Removes a specific member
    public void removeFromTeam(T member) {
        list.remove(member);
    }

    // Returns the number of members
    public int getNumberOfMembers() {
        return list.size();
    }

    // Checks if the team has no members
    public boolean hasNoMembers() {
        return list.isEmpty();
    }

    // Allows iteration over the team members
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    // String representation of all members
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T member : list) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }

    // Sort the team members in-place with Comparator
    public void sort(Comparator<? super T> comparator) {
        list.sort(comparator);
    }
}
