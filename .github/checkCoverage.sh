export INCOMPLETE_COVERAGE=false
while read p; do
    arrIN=(${p//,/ })
    sourceFile=${arrIN[0]}
    testFile=${arrIN[1]}
    echo $sourceFile
    echo $testFile
    line_coverage_for_file=$(cat coverage_report.txt | grep $sourceFile | awk '{print $2}')
    if [[ $line_coverage_for_file -lt 80 ]]; then
        find . -name "$testFile" -type f -delete
        export INCOMPLETE_COVERAGE=true
    fi
done <src_test_coverage.txt

echo $INCOMPLETE_COVERAGE
echo "INCOMPLETE_COVERAGE=$(echo $INCOMPLETE_COVERAGE)" >> $GITHUB_ENV