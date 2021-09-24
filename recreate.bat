@echo off
echo "Deleting jenkins..."
helm delete jenkins -n=jenkins

REM Deleting jenkins deployment can take a time especially deleting pvc
REM To be sure that pvc is deleted run `kubectl get pvc --namespace=jenkins`
timeout /t 15 /nobreak

echo "Installing jenkins..."
helm install jenkins jenkins/jenkins  -f ./helm/jenkins/values.yaml -n=jenkins


