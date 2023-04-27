lastlatestTS=$(cat latestTS.txt | cut -d ',' -f1)
java -jar target/get-slack-message-1.0-SNAPSHOT-jar-with-dependencies.jar C03JBB2CX2A xoxb-3566422073617-4046389058707-SKEvLM5TRMNlOugFtJiDrx6m > latestTS.txt
latestTS=$(cat latestTS.txt | cut -d ',' -f1)
echo $lastlatestTS
echo $latestTS
if [[ "$lastlatestTS" == "$latestTS" ]]
then
    todo jenkins
fi