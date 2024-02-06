/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Job implements Comparable<Job>{
	/**
	 *Declaring private variables for a Job
	 */
	private int id;
	private int group;
	private long size;
	/**
	 * Creates a Job with id, group and size specified
	 * @param id An int that contains the value for id
	 * @param group An int that contains the value for group
	 * @param size A long that contains the value for size
	 */
	public Job(int id, int group, long size) {
		this.id = id;
		this.group = group;
		this.size = size;
	}
	/**
	 * Getter for the size of the job
	 * @return A long value that represents the size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * Method used to print a formatted Job object
	 */
	public String toString() {
		String output = String.format("%-8d\t%-10d\t", id, group);
		double size2 = size;
		int KB = 1024;
		int MB = 1024 * 1024;
		int GB = 1024 * 1024 * 1024;
		if(size2 > GB) {
			size2 = size2 / GB;
			output += String.format("%.1fGB", size2);
		} else if(size2 > MB) {
			size2 = size2 / MB;
			output += String.format("%.1fMB", size2);
		} else if(size2 > KB) {
			size2 = size2 / KB;
			output += String.format("%.1fKB", size2);
		} else {
			output += String.format("%d bytes", size2);
		}
		return output;
	}
	/**
	 * Method used to compare two jobs by comparing their groups
	 */
	public int compareTo(Job j) {
		Integer g1 = this.group;
		Integer g2 = j.group;
		return g1.compareTo(g2);
	}
}
