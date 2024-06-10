@echo off
@rem Check if java is installed
where /q java.exe
if %errorlevel% neq 0 (
    echo Please install java before running this app!
    exit 1
)

@rem Run gradle tasks (assuming gradlew is executable)
"%~dp0gradlew.bat" clean build

@rem Run the Sort.jar with all arguments passed to the script
java -jar "%~dp0build\libs\Sort.jar"  %*
