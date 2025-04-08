using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace crud
{
    public partial class Default : System.Web.UI.Page
    {
        string constr = ConfigurationManager.ConnectionStrings["conn"].ConnectionString;
        protected void Page_Load(object sender, EventArgs e)
        {
            showdata();
        }
        private void showdata()
        {
            try
            {
                SqlConnection cn = new SqlConnection(constr);
                cn.Open();
                SqlCommand cmd = new SqlCommand("select * from demo", cn);
                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataTable dt = new DataTable();
                da.Fill(dt);
                if (dt.Rows.Count > 0)
                {
                    GridView1.DataSource = dt;
                    GridView1.DataBind();
                }
                else
                {
                    Response.Write("no data found");
                }
            }
            catch (Exception ex)
            {

                throw ex;
            }
        }
        protected void btnins_Click(object sender, EventArgs e)
        {
            adddata();
        }

        private void adddata()
        {
            try
            {
                SqlConnection cn = new SqlConnection(constr);
                cn.Open();
                SqlCommand cmd = new SqlCommand("insert into demo (name,surname,email,password,mobileno,gender,date) values (@nm,@snm,@email,@pass,@mn,@gender,@dt)", cn);
                cmd.Parameters.AddWithValue("@nm", txtnm.Text);
                cmd.Parameters.AddWithValue("@snm", txtsnm.Text);
                cmd.Parameters.AddWithValue("@email", txtemail.Text);
                cmd.Parameters.AddWithValue("@pass", txtpass.Text);
                cmd.Parameters.AddWithValue("@mn", txtmn.Text);
                cmd.Parameters.AddWithValue("@gender", txtgender.Text);
                cmd.Parameters.AddWithValue("@dt", DateTime.Parse(txtdt.Text));
                cmd.ExecuteNonQuery();
                cn.Close();
                showdata();
                ClearFields();
                txtnm.Text = "";
                txtsnm.Text = "";
                txtemail.Text = "";
                txtpass.Text = "";
                txtmn.Text = "";
                txtgender.Text = "";
                txtdt.Text = "";
            }
            catch (Exception ex)
            {

                throw ex;
            }
        }

        protected void btnshow_Click(object sender, EventArgs e)
        {
            finddata();
        }

        private void finddata()
        {
            try
            {
                SqlConnection cn = new SqlConnection(constr);
                cn.Open();
                SqlCommand cmd = new SqlCommand("select * from demo where id=@id", cn);
                cmd.Parameters.AddWithValue("@id", txtid.Text);
                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataTable dt = new DataTable();
                da.Fill(dt);
                if (dt.Rows.Count > 0)
                {
                    txtnm.Text = dt.Rows[0]["name"].ToString();
                    txtsnm.Text = dt.Rows[0]["surname"].ToString();
                    txtemail.Text = dt.Rows[0]["email"].ToString();
                    txtpass.Text = dt.Rows[0]["password"].ToString();
                    txtmn.Text = dt.Rows[0]["mobileno"].ToString();
                    txtgender.Text = dt.Rows[0]["gender"].ToString();
                    txtdt.Text = dt.Rows[0]["date"].ToString();
                }
                else
                {
                    Response.Write("no data found");
                }
            }
            catch (Exception ex)
            {

                throw ex;
            }
        }

        protected void btnupdate_Click(object sender, EventArgs e)
        {
            updatedata();
        }

        private void updatedata()
        {
            try
            {
                SqlConnection cn = new SqlConnection(constr);
                cn.Open();
                SqlCommand cmd = new SqlCommand("update demo set name=@nm,surname=@snm,email=@email,password=@pass,mobileno=@mn,gender=@gender,date=@dt", cn);
                cmd.Parameters.AddWithValue("@nm", txtnm.Text);
                cmd.Parameters.AddWithValue("@snm", txtsnm.Text);
                cmd.Parameters.AddWithValue("@email", txtemail.Text);
                cmd.Parameters.AddWithValue("@pass", txtpass.Text);
                cmd.Parameters.AddWithValue("@mn", txtmn.Text);
                cmd.Parameters.AddWithValue("@gender", txtgender.Text);
                cmd.Parameters.AddWithValue("@dt", txtdt.Text);
                cmd.ExecuteNonQuery();
                cn.Close();
                showdata();
                ClearFields();
                txtnm.Text = "";
                txtsnm.Text = "";
                txtemail.Text = "";
                txtpass.Text = "";
                txtmn.Text = "";
                txtgender.Text = "";
                txtdt.Text = "";
                txtid.Text = "";
            }
            catch (Exception ex)
            {

                throw ex;
            }
        }

        protected void btndlt_Click(object sender, EventArgs e)
        {
            deletedata();
        }

        private void deletedata()
        {
            try
            {
                SqlConnection cn = new SqlConnection(constr);
                cn.Open();
                SqlCommand cmd = new SqlCommand("delete from demo where id=@id", cn);
                cmd.Parameters.AddWithValue("@id", txtid.Text);
                cmd.ExecuteNonQuery();
                cn.Close();
                showdata();
                ClearFields();
                txtid.Text = "";
            }
            catch (Exception ex)
            {

                throw ex;
            }
        }
        private void ClearFields()
        {
            txtid.Text = "";
            txtnm.Text = "";
            txtsnm.Text = "";
            txtemail.Text = "";
            txtpass.Text = "";
            txtmn.Text = "";
            txtgender.Text = "";
            txtdt.Text = "";
        }
    }
}
