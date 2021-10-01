@echo off
echo "Upgrading jenkins..."
helm upgrade jenkins jenkins/jenkins  -f ./helm/jenkins/values.yaml -n=jenkins


