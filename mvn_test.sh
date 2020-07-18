#!/bin/bash
mvn test -DuserEmail=$REGRESSION_USER -DuserPassword=$REGRESSION_PASSWORD
VAR=$?
tar -cvzf regression-report.tar.gz ./test-output/HtmlReport/
exit $VAR 
