


```bash

# SAST
snyk code test -d --sarif-file-output=snyk-sast.sarif

# SCA
snyk test -d --sarif-file-output=snyk-sca.sarif

# Monitor your organization project
snyk monitor  --project-name=springboot-task-tracker-h2-api --org=$PROJECT_ORGANIZATION

```



- [Snyk Code security rules](https://docs.snyk.io/scan-with-snyk/snyk-code/snyk-code-security-rules)

### Issues
- [Remote Code Execution (RCE)](https://security.snyk.io/vuln/SNYK-JAVA-COMH2DATABASE-31685)
- [Uncontrolled Resource Consumption ('Resource Exhaustion')](https://security.snyk.io/vuln/SNYK-JAVA-CHQOSLOGBACK-6097492)
- [Denial of Service (DoS)](https://security.snyk.io/vuln/SNYK-JAVA-CHQOSLOGBACK-6094942)