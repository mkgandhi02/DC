
import java.util.ArrayList;
import java.util.List;

class Process {
private int id;
private int priority;
private boolean coordinator;
public Process(int id, int priority) {
this.id = id;
this.priority = priority;
this.coordinator = false;
}
public int getId() {
return id;
}
public int getPriority() {
return priority;
}
public boolean isCoordinator() {
return coordinator;
}
public void setCoordinator(boolean coordinator) {
this.coordinator = coordinator;
}
public void startElection(List<Process> processes) {
System.out.println("Process " + id + " is starting election.");
for (Process p : processes) {
if (p.getPriority() > priority) {
System.out.println("Process " + id + " sends election message to Process " + 
p.getId());
p.receiveElection();
}
}
}
public void receiveElection() {
System.out.println("Process " + id + " receives election message.");
}
public void declareVictory(List<Process> processes) {
Process newCoordinator = this;
for (Process p : processes) {
if (p.getPriority() > newCoordinator.getPriority()) {
newCoordinator = p;
}
}
for(Process p : processes){
if(p!= newCoordinator){
p.setCoordinator(false);
}
}
newCoordinator.setCoordinator(true);
System.out.println("Process " + newCoordinator.getId() + " is the new coordinator.");
}
}
public class BullyAlgorithm {
public static void main(String[] args) {
List<Process> processes = new ArrayList<>();
processes.add(new Process(1, 3));
processes.add(new Process(2, 5));
processes.add(new Process(3, 4));
processes.add(new Process(4, 2));
processes.add(new Process(5, 1));
processes.get(0).setCoordinator(false);
for (Process process : processes) {
if (process.isCoordinator()) {
System.out.println("Process " + process.getId() + " is already the coordinator.");
} else {
process.startElection(processes);
break;
}
}
processes.get(4).declareVictory(processes);
}
}
