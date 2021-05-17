const report = require('multiple-cucumber-html-reporter');

report.generate({
    jsonDir: './src/test/resources/report/',
    reportPath: './src/test/resources/report/',
    metadata:{
        browser: {
            name: 'chrome',
            version: '60'
        },
        device: 'Local test machine',
        platform: {
            name: 'ubuntu',
            version: '16.04'
        }
    },
    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'LoginChallenge'},
            {label: 'Release', value: '1.0'},
            {label: 'Cycle', value: '1'},
            {label: 'Execution Start Time', value: 'Nov 19th 2017, 02:31 PM EST'},
            {label: 'Author', value: 'Brian'}
        ]
    }
});