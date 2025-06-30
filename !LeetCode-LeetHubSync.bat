@echo off

echo LeetCode-LeetHub-Begin
	set "repoLocation=C:\Users\User\eclipse-workspace\LeetCode-LeetHub"
	set "gitPath=C:\Program Files\Git\cmd\git.exe"
	cd /d "%repoLocation%"
	if not exist "%repoLocation%\.git" (
		"%gitPath%" init
	)
	"%gitPath%" pull
	"%gitPath%" add .
	set commitMessage=LenovoBat %date% %time%
	"%gitPath%" commit -m "%commitMessage%"
	"%gitPath%" push
echo LeetCode-LeetHub-End


exit