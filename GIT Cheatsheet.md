# GIT Cheatsheet

Basic cheatsheet made by Aniol0012. For more information follow [git documentation](https://git-scm.com/doc). Git it's mostly used in combination with [GitHub](https://github.com), check out its [documentation](https://docs.github.com). 

---
## Table of contents
- [[#Setup|Setup]]
- [[#Setup & Init|Setup & Init]]
- [[#Stage & Snapshot|Stage & Snapshot]]
- [[#Branch & Merge|Branch & Merge]]
- [[#Inspect & Compare|Inspect & Compare]]

---
## Setup

Configuring user information used across all local repositories

- Set a name that is identifiable for credit when review version history
```sh
git config --global user.name “[firstname lastname]”
```

- Set an email address that will be associated with each history marker
```sh
git config --global user.email “[valid-email]”
```

- Set automatic command line coloring for Git for easy reviewing
```sh
git config --global color.ui auto
```

---
## Setup & Init
Configuring user information, initializing and cloning repositories

- Initialize an existing directory as a Git repository
```sh
git init
```
- Retrieve an entire repository from a hosted location via URL
```sh
git clone [url]
```

---
## Stage & Snapshot

Working with snapshots and the Git staging area. Use `.` instead of `[file]` to add all files.

- Show modified files in working directory, staged for your next commit
```sh
git status
```
- Add file as it looks now to your next commit (stage)
```sh
git add [file] or .
```
- Unstage a file while retaining the changes in working directory
```sh
git reset [file]
```
- Diff of what is changed but not staged
```sh
git diff
```
- Diff of what is staged but not yet committed
```sh
git diff --staged
```
- Commit your staged content as a new commit snapshot
```sh
git commit -m “[descriptive message]”
```
You can also use next command to add commit tag in the commit message:
```sh
git commit -m "Commit $(git rev-parse --short HEAD)"
```
Or add commit number:
```sh
git commit -m "Commit number $(($(git rev-list --count HEAD) + 1))"
```

---
## Branch & Merge

Isolating work in branches, changing context, and integrating changes

- List your branches. A ```*``` will appear next to the currently active branch
```sh
git branch
```
- Create a new branch at the current commit
```sh
git branch [branch-name]
```
- Switch to another branch and check it out into your working directory
```sh
git checkout
```
- Merge the specified branch’s history into the current one
```sh
git merge [branch]
```
- Show all commits in the current branch’s history
```sh
git log
```

---
## Inspect & Compare

Examining logs, diffs and object information

- Show the commit history for the currently active branch
```sh
git log
```
- Show the commits on branchA that are not on branchB
```sh
git log branchB..branchA
```
- Show the commits that changed file, even across renames
```sh
git log --follow [file]
```
- Show the diff of what is in branchA that is not in branchB
```sh
git diff branchB...branchA
```
- Show any object in Git in human-readable format
```sh
git diff branchB...branchA
```

---
## Tracking Path Changes

Versioning file removes and path changes

- Delete the file from project and stage the removal for commit
```sh
git rm [file]
```

- Change an existing file path and stage the move
```sh
git mv [existing-path] [new-path]
```
- Show all commit logs with indication of any paths that moved
```sh
git log --stat -M
```
---
## Ignoring Patterns

Preventing unintentional staging or commiting of files

- Save a file with desired patterns as `.gitignore` with either direct string matches or wildcard globs
```
logs/
*.notes
pattern*/
```

- System wide ignore pattern for all local repositories
```sh
git config --global core.excludesfile [file]
```

---
## Share & Update


---
## Rewrite History


---
## Temporary Commits


