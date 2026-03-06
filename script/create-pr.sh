#!/bin/bash

TICKET="$1"

# Extract ticket id
TICKET_ID=$(echo "$TICKET" | awk '{print $1}')

# Extract message
MESSAGE=$(echo "$TICKET" | cut -d' ' -f2-)

BRANCH=$TICKET_ID
COMMIT_MSG=$MESSAGE

echo "Branch: $BRANCH"
echo "Commit: $COMMIT_MSG"

git checkout -b $BRANCH

git add .

git commit -m "$COMMIT_MSG"

git push origin $BRANCH

gh pr create \
  --title "$TICKET" \
  --body "Auto generated from ticket $TICKET_ID" \
  --base main \
  --head $BRANCH
