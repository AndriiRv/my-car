echo off
cls

echo.
echo - Re-create ssh-volume docker volume.
call ../../createSshVolume.bat

echo.
echo - Start all docker containers with production profiles.
echo.

docker-compose -f docker-compose-message-brokers.yml -f docker-compose-microservices.yml -f docker-compose-db.yml -f docker-compose-business-microservices.yml -f docker-compose.yml up -d

echo.
echo - All docker containers started successfully.
echo.

PAUSE
