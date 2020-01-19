# Contributing

We'd love to accept your patches and contributions! There are just a few small guidelines you
need to follow.

## Proposed Changes

First, submit an issue describing your proposed change to the repository even if you think it's
minor; it's helpful to know what people are working on. The project members will respond
to your issue accordingly. If your proposed change is accepted, you may start forking the
repository, developing, and testing your code changes.

## Code Reviews

All submissions, including submissions by project members, require code review.
We use GitHub pull requests for this purpose. Consult [GitHub Help][github-help]
for more information on using pull requests.

### Git Commit Message Convention

It is preferred that you follow the 50/72 rule as much as possible for git commit messages:

1. Separate subject from body with a blank line
2. Limit the subject line to 50 characters
3. Capitalize the subject line
4. Do not end the subject line with a period
5. Use the imperative mood in the subject line
6. Wrap the body at 72 characters
7. Use the body to explain what and why vs. how

See this great post where this rule is explained further:
[How to Write a Git Commit Message][git-commit-message]

## Testing

Ensure that for every new pull request that your code has an appropriate set of
unit tests which all pass. To run tests locally, run:
```bash
$ ./gradlew test
```

## Code Style

This project uses [`klint`][klint-url] and [`google-java-format`][google-java-format-url],
provided via the [spotless][spotless-url] gradle plugin. This allows us to follow the
official code styles from [Google Java][java-code-style], [Kotlin][kotlin-code-style], and
[Android][android-code-style].

To check for code styling errors, run:
```bash
$ ./gradlew spotlessCheck
```

To fix your code styling errors, run:
```bash
$ ./gradlew spotlessApply
```

<!-- Links to spotless formatter tools and code style guides. -->
[git-commit-message]: https://chris.beams.io/posts/git-commit/
[spotless-url]: https://github.com/diffplug/spotless
[klint-url]: https://github.com/pinterest/ktlint
[google-java-format-url]: https://github.com/google/google-java-format
[android-code-style]: https://developer.android.com/kotlin/style-guide
[java-code-style]: https://google.github.io/styleguide/javaguide.html
[kotlin-code-style]: https://kotlinlang.org/docs/reference/coding-conventions.html
[github-help]: https://help.github.com/articles/about-pull-requests/
