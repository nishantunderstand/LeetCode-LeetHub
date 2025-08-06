@echo off
echo ==== Begin Git Auto Push ====

REM Get the directory where the batch file is located
set "repoLocation=%~dp0"

REM Git executable path
set "gitPath=C:\Program Files\Git\cmd\git.exe"

REM Change to repo directory
cd /d "%repoLocation%"

REM Initialize Git repo if not already present
if not exist "%repoLocation%\.git" (
    "%gitPath%" init
)

REM Pull latest changes (optional)
"%gitPath%" pull

REM Add all files
"%gitPath%" add .

REM Create commit message with timestamp
set "commitMessage=LenovoBat %date% %time%"

REM Commit changes
"%gitPath%" commit -m "%commitMessage%"

REM Push to remote
"%gitPath%" push

echo ==== End ====
exit