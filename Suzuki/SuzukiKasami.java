import java.util.*;
class Site {
int siteId;
int[] RN;
int[] LN;
Site(int siteId, int numSites) {
this.siteId = siteId;
RN = new int[numSites];
LN = new int[numSites];
}
}
public class SuzukiKasami {
static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
System.out.print("Enter the number of sites: ");
int numSites = scanner.nextInt();
System.out.print("Enter the site ID which initially has the token (1-"+ numSites + "): ");
int initialTokenSiteId = scanner.nextInt();
if (initialTokenSiteId < 1 || initialTokenSiteId > numSites) {
System.out.println("Invalid site ID for initial token holder.");
return;
}
SuzukiKasami suzukiKasami = new SuzukiKasami(numSites, initialTokenSiteId);
suzukiKasami.simulate();
}
int numSites;
Site[] sites;
Queue<Integer> tokenQueue;
int currentTokenHolder;
SuzukiKasami(int numSites, int initialTokenSiteId) {
this.numSites = numSites;
sites = new Site[numSites];
for (int i = 0; i < numSites; i++) {
sites[i] = new Site(i + 1, numSites);
}
currentTokenHolder = initialTokenSiteId;
tokenQueue = new LinkedList<>();
}
void simulate() {
while (true) {
System.out.println("Site " + currentTokenHolder + " has the token.");
// Execute critical section
System.out.println("Site " + currentTokenHolder + " executes critical section.");
// Release critical section
int[] currentLNs = sites[currentTokenHolder - 1].LN;
int[] currentRNs = sites[currentTokenHolder - 1].RN;
currentLNs[currentTokenHolder - 1] = currentRNs[currentTokenHolder
- 1];
for (int j = 0; j < numSites; j++) {
if (!tokenQueue.contains(j + 1) && currentRNs[j] == currentLNs[j] + 1) {
tokenQueue.offer(j + 1);
}
}
if (!tokenQueue.isEmpty()) {
int nextTokenHolder = tokenQueue.poll();
System.out.println("Token sent from Site " + 
currentTokenHolder + " to Site " + nextTokenHolder);
currentTokenHolder = nextTokenHolder;
} else {
System.out.println("Site " + currentTokenHolder + " retains the token.");
}
// Simulate next site requesting the token
System.out.print("Enter the site ID that wants to enter the critical section (1-" + numSites + "): ");
int requestingSiteId = scanner.nextInt();
if (requestingSiteId < 1 || requestingSiteId > numSites) {
System.out.println("Invalid site ID.");
return;
}
requestCriticalSection(requestingSiteId);
}
}
void requestCriticalSection(int requestingSiteId) {
System.out.println("Site " + requestingSiteId + " requests the critical section.");
sites[requestingSiteId - 1].RN[requestingSiteId - 1]++;
for (int i = 0; i < numSites; i++) {
if (i != requestingSiteId - 1) {
sites[i].RN[requestingSiteId - 1] = Math.max(sites[i].RN[requestingSiteId - 1],sites[requestingSiteId - 1].RN[requestingSiteId - 1]);
if (currentTokenHolder == i + 1 && sites[i].RN[requestingSiteId - 1] == sites[i].LN[requestingSiteId - 1] + 1) {
System.out.println("Token sent from Site " + 
currentTokenHolder + " to Site " + requestingSiteId);
currentTokenHolder = requestingSiteId;
}
}
}
}
}
