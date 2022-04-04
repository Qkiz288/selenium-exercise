# Selenium Webdriver exercises

If you get the following error while running the test:

`“chromedriver” cannot be opened because the developer cannot be verified". "macOS cannot verify that this app is free from malware."`

Go to `src/main/resources/driver` directory and run:

`xattr -d com.apple.quarantine chromedriver_99` 