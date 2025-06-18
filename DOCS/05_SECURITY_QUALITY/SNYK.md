


```bash
# SAST
snyk code test -d --sarif-file-output=snyk-sast.sarif

# SCA
snyk test -d --sarif-file-output=snyk-sca.sarif

# Monitor your organization project
snyk monitor  --project-name=springboot-task-tracker-h2-api-local-monitor --org=$SNYK_PROJECT_ORGANIZATION

```


### Snyk References
- [Snyk Code security rules](https://docs.snyk.io/scan-with-snyk/snyk-code/snyk-code-security-rules)
- [Environment variables for Snyk CLI](https://docs.snyk.io/snyk-cli/configure-the-snyk-cli/environment-variables-for-snyk-cli)
- [Maven plugin integration with Snyk](https://docs.snyk.io/scm-ide-and-ci-cd-workflow-and-integrations/snyk-ci-cd-integrations/maven-plugin-integration-with-snyk)
- [Snyk API token permissions users can control](https://docs.snyk.io/snyk-api/rest-api/authentication-for-api/api-token-permissions-users-can-control)
- [Brew: Snyk](https://formulae.brew.sh/formula/snyk-cli)


### Issues
- [Remote Code Execution (RCE)](https://security.snyk.io/vuln/SNYK-JAVA-COMH2DATABASE-31685)
- [Uncontrolled Resource Consumption ('Resource Exhaustion')](https://security.snyk.io/vuln/SNYK-JAVA-CHQOSLOGBACK-6097492)
- [Denial of Service (DoS)](https://security.snyk.io/vuln/SNYK-JAVA-CHQOSLOGBACK-6094942)


### Solving Issues
- [What is the meaning of exit 0, exit 1, and exit 2 in a bash script?](https://askubuntu.com/questions/892604/what-is-the-meaning-of-exit-0-exit-1-and-exit-2-in-a-bash-script)