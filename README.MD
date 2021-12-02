# DevOps Coding Challenge

This is a hands-on assessment of `Docker`, `Kubernetes`, `CI/CD`, and use of `AWS`.

## Rules

- Complete the challenge within 5 days, mention time spent in hours explicitly took for solving the challenge
- **Please do not spend more than a few hours on this challenge.** We are absolutely not looking for perfection, we expect trade-offs to be made
- Your solution should be clean, readable, maintainable and implemented with emphasize on DevOps methodologies
- You are free to use the programming language, tools and cloud platform of your choice

## Evaluation

**For each objective below please provide a description, execution steps and testing steps in [NOTES.MD](./NOTES.MD)**

## Challenge

_Developers have created an app that works in their local environment. It needs to be deployed securely into Kubernetes._

_Using best practices and taking thorough notes please complete the objectives below._

### Objective #1 : Create a workspace

DevOps Work requires continuous integration.

- `Fork` this repo into your own Github account
- Add user `stefancrain` to your forked repo with read access
- Make proper use of `git` branching to complete the objectives below
- Upon completion of all objectives `push` the branch to remote

### Objective #2 : Review and Publish the App

DevOps requires Application team mentorship. This app displays ssh keys for system admins.

- Review and update the [Dockerfile](./Dockerfile). **Be sure that the Dockerfile is following best practices**
- Generate a new ssh key, add it to the `/app` folder
- Write code to complete the Docker `build`, `test`, and `publish` the image to an Artifact repository
  - This can be in any format, but should be an executable

### Objective #3 : Deploy the app using Kubernetes

- Create an app manifest within [pod.yml](./pod.yml)
- Using kubernetes deploy the app to
  - Local environments
  - **Bonus for AWS Deployment, even if conceptual**

### Objective #4 : Monitor the app

- Suggest best practices for monitoring
