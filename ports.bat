start cmd.exe /k @cmd "kubectl -n=jenkins port-forward svc/jenkins 9090:8080"

start cmd.exe /k @cmd "kubectl -n=production port-forward svc/flight-service-app 9091:3000"

start cmd.exe /k @cmd "kubectl -n=development port-forward svc/flight-service-app 9092:3000"

start cmd.exe /k @cmd "kubectl -n=staging port-forward svc/flight-service-app 9093:3000"
