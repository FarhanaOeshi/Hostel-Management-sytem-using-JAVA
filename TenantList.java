import java.util.ArrayList;

/**
 * TenantList Class: Collection class to hold a list of tenants.
 * @author Adrian Adewunmi
 * @version 10 January 2021
 * Reproduced from "Java in Two Semesters: Featuring JavaFX. Springer" (Case Study - Part 1 / Case Study - Part 2).
 * Charatan, Q., & Kans, A. (2019). Java in Two Semesters: Featuring JavaFX. Springer.
 */

public class TenantList {
    private final ArrayList<Tenant> tenantArrayList;
    public final int MAX;

    /**
     * Constructor initialises the empty tenant list and sets the maximum list size
     * @param maxIn The maximum number of tenants in the list
     */

    public TenantList(int maxIn) {
        this.tenantArrayList = new ArrayList<>();
        this.MAX = maxIn;
    }

    /**
     * Adds a new tenant to the list
     * @param tIn The tenant to add
     * @return Returns true if the tenant was added successfully and false otherwise
     */

    public boolean addTenant(Tenant tIn){
        if(!isFull()){
            tenantArrayList.add(tIn);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Removes the tenant in the given room number
     * @param roomIn The room number of the tenant to remove
     * @return Returns true if the tenant is removed successfully of false otherwise
     */

    public boolean removeTenant(int roomIn){
        Tenant findT = search(roomIn); // call search method
        if(findT != null) // check tenant is found at given room
        {
            tenantArrayList.remove(findT); // remove given tenant
            return true;
        }else{
            return false;
        }
    }

    /**
     * Searches for the tenant in the given room number
     * @param roomIn The room number to search for
     * @return Return the tenant in the given room or null if no tenant in the given room
     */

    public Tenant search(int roomIn){
        for (Tenant currentTenant : tenantArrayList) {
            // find tenant with given room number
            if(currentTenant.getRoom() == roomIn){
                return currentTenant;
            }
        }
        return null; // no tenant found with given room number
    }

    /**
     * Reads the tenant at the given position in the list
     * @param positionIn The logical position of the tenant in the list
     * @return Returns the tenant at the given logical position in the list
     *          oor null if no tenant at that logical position
     */

    public Tenant getTenant(int positionIn){
        if(positionIn < 1 || positionIn > getTotal()) // check for valid position
        {
            return null; // no object found at given position
        }else{
            // remove one from logical position to get ArrayList position
            return tenantArrayList.get(positionIn - 1);
        }
    }

    /**
     * Reports on whether or not the list is empty
     * @return Returns true if the list is empty and false otherwise
     */

    public boolean isEmpty(){
        return tenantArrayList.isEmpty();
    }

    /**
     * Reports on whether oor not the list is full
     * @return Returns true if the list is empty and false otherwise
     */

    public boolean isFull(){
        return tenantArrayList.size() == MAX;
    }

    /**
     * Gets the total number of tenants
     * @returns Returns the total number of tenants currently in the list
     */

    public int getTotal(){
        return tenantArrayList.size();
    }

    @Override
    public String toString() {
        return tenantArrayList.toString();
    }
}
