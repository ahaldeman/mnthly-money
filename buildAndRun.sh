echo "Building mnthly-money image..."

docker build -t mnthly-money .

echo "Running app with Postgres DB..."

docker compose up