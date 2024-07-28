#!/bin/bash
docker compose up -d --force-recreate --build
docker system prune -f