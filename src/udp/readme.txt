1. Start server using (adjust classpath parameter -cp to let it point to your directory that contains the ds_04 subdirectory that contain the *.class files)
java -cp /home/helmut/workspace/DistributedSystems/bin/ ds_04.udp.UDPServer

2. Start on same machine client using (adjust classpath)
java -cp /home/helmut/workspace/DistributedSystems/bin/ ds_04.udp.UDPClient Hello localhost