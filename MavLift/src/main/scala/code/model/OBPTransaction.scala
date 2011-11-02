package code.model

import net.liftweb.mongodb.record.field.{BsonRecordField, ObjectIdPk}
import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord, BsonMetaRecord, BsonRecord}


class Location private () extends BsonRecord[Location] {
  def meta = Location

  object longitude extends net.liftweb.record.field.IntField(this)
  object latitude extends net.liftweb.record.field.IntField(this)

}
object Location extends Location with BsonMetaRecord[Location]



class OBPTransaction private() extends MongoRecord[OBPTransaction] with ObjectIdPk[OBPTransaction] {
  def meta = OBPTransaction // what does meta do?

  object obp_transaction_date_start extends net.liftweb.record.field.DateTimeField(this)
  object obp_transaction_date_complete extends net.liftweb.record.field.DateTimeField(this)

  object obp_transaction_type_en extends net.liftweb.record.field.StringField(this, 255)
  object obp_transaction_type_de extends net.liftweb.record.field.StringField(this, 255)
  object obp_transaction_data_blob extends net.liftweb.record.field.StringField(this, 999999)
  object opb_transaction_other_account extends net.liftweb.record.field.StringField(this, 255)

  object obp_transaction_currency extends net.liftweb.record.field.StringField(this, 10)
  object obp_transaction_amount extends net.liftweb.record.field.StringField(this, 20)
  object obp_transaction_new_balance extends net.liftweb.record.field.StringField(this, 20)

  object obp_transaction_location extends BsonRecordField(this, Location)

}

object OBPTransaction extends OBPTransaction with MongoMetaRecord[OBPTransaction]


///


// Seems to map to a collection of the plural name
class OBPEnvelope private() extends MongoRecord[OBPEnvelope] with ObjectIdPk[OBPEnvelope] {
  def meta = OBPEnvelope

  // This creates a json attribute called "obp_transaction"
  object obp_transaction extends BsonRecordField(this, OBPTransaction)

}

object OBPEnvelope extends OBPEnvelope with MongoMetaRecord[OBPEnvelope]