@echo off
echo "Upgrading jenkins..."
helm upgrade jenkins jenkins/jenkins  -f ./jenkins/helm/values.yaml -n=jenkins


