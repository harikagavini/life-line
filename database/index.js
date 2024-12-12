const fs = require('fs');
const path = require('path');
const mysql = require('mysql2/promise');

const dbConfig = {
  host: 'localhost',
  user: 'root',
  password: 'Qwerty12345',
  database: 'lifeline'
};

const schemasExecutionOrder = [
  './schemas/authreq.sql',
  './schemas/donor.sql',
  './schemas/hospital_location.sql',
  './schemas/blood_bank.sql',
  './schemas/storage.sql',
  './schemas/events.sql',
  './schemas/orders.sql',
  './schemas/services.sql',
  './schemas/reward.sql',
  './schemas/service_visit.sql',
  './schemas/donation.sql',
];

const triggers = [
  './triggers/donation_storage_trigger.sql',
  './triggers/donation_reward_trigger.sql',


];

async function executeQueries(files) {
  for (const file of files) {
    const fileContent = await fs.promises.readFile(file, 'utf8');
    try {
      const [results] = await dbConnection.query(fileContent);
      console.log(`Executed query from file ${file} successfully`);
    } catch (error) {
      console.error(`Error executing query from file ${file}: ${error.message}`);
    }
  }
}

async function main() {
  try {
    global.dbConnection = await mysql.createConnection(dbConfig);
    await executeQueries(schemasExecutionOrder);
    await executeQueries(triggers);
    await dbConnection.end();
  } catch (error) {
    console.error(`Error while executing queries: ${error.message}`);
  }
}

main();
