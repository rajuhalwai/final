<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="crud.Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    <table>
                <tr>
                    <td>id</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtid" />
                    </td>
                </tr>
                <tr>
                    <td>name</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtnm" />
                    </td>
                </tr>
                <tr>
                    <td>surname</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtsnm" />
                    </td>
                </tr>
                <tr>
                    <td>email</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtemail" TextMode="Email" />
                    </td>
                </tr>
                <tr>
                    <td>password</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtpass" TextMode="Password" />
                    </td>
                </tr>
                <tr>
                    <td>mobile no</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtmn" />
                    </td>
                </tr>
                <tr>
                    <td>gender</td>
                    <td>
                        <asp:RadioButtonList runat="server" ID="txtgender">
                            <asp:ListItem Text="Male" Value="gender" />
                            <asp:ListItem Text="Female" Value="gender" />
                        </asp:RadioButtonList>
                    </td>
                </tr>
                <tr>
                    <td>date</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtdt" TextMode="Date" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <asp:Button Text="insert" runat="server" ID="btnins" OnClick="btnins_Click" />
                        <asp:Button Text="show" runat="server" ID="btnshow" OnClick="btnshow_Click" />
                        <asp:button text="update" runat="server" id="btnupdate" OnClick="btnupdate_Click" />
                        <asp:button text="delete" runat="server" id="btndlt" OnClick="btndlt_Click" />
                    </td>
                </tr>
            </table>
        </div>
        <asp:GridView ID="GridView1" runat="server" Width="490px" AutoGenerateColumns="False" DataKeyNames="id" CellPadding="4" ForeColor="#333333" GridLines="None">
            <AlternatingRowStyle BackColor="White" />
            <Columns>
                <asp:BoundField DataField="id" HeaderText="id" InsertVisible="False" ReadOnly="True" SortExpression="id" />
                <asp:BoundField DataField="name" HeaderText="name" SortExpression="name" />
                <asp:BoundField DataField="surname" HeaderText="surname" SortExpression="surname" />
                <asp:BoundField DataField="email" HeaderText="email" SortExpression="email" />
                <asp:BoundField DataField="password" HeaderText="password" SortExpression="password" />
                <asp:BoundField DataField="mobileno" HeaderText="mobileno" SortExpression="mobileno" />
                <asp:BoundField DataField="gender" HeaderText="gender" SortExpression="gender" />
                <asp:BoundField DataField="date" HeaderText="date" SortExpression="date" />
            </Columns>
            <EditRowStyle BackColor="#2461BF" />
            <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#EFF3FB" />
            <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#F5F7FB" />
            <SortedAscendingHeaderStyle BackColor="#6D95E1" />
            <SortedDescendingCellStyle BackColor="#E9EBEF" />
            <SortedDescendingHeaderStyle BackColor="#4870BE" />
        </asp:GridView>
         <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:conn %>" SelectCommand="SELECT * FROM [demo]"></asp:SqlDataSource>
   
    </form>
</body>
</html>
