using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DrugAdministration
{
    public partial class SystemInterface : Form
    {
        public SystemInterface()
        {
            InitializeComponent();
        }

        private void SystemInterface_Load(object sender, EventArgs e)
        {
            this.tbp_cgd.Parent = null;
            this.tbp_cgdd.Parent = null;
            this.tbp_ck.Parent = null;
            this.tbp_db.Parent = null;
            this.tbp_fkd.Parent = null;
            this.tbp_gys.Parent = null;
            this.tbp_gyslb.Parent = null;
            this.tbp_jldw.Parent = null;
            this.tbp_pd.Parent = null;
            this.tbp_rk.Parent = null;
            this.tbp_skd.Parent = null;
            this.tbp_xsd.Parent = null;
            this.tbp_xsdd.Parent=null;
            this.tbp_yp.Parent = null;
            this.tbp_ypzl.Parent = null;
            this.tbp_zjhz.Parent = null;
        }

        private void menuStrip2_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void menuStrip2_ItemClicked_1(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void menuStrip2_ItemClicked_2(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void menuStrip2_ItemClicked_3(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void SystemInterface_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void now_timer_Tick(object sender, EventArgs e)
        {
            time_label.Text = DateTime.Now.ToString("yyyy-MM-dd HH:mm");
        }

        private void 采购单ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_cgd.Parent=this.tbc;
            this.tbc.SelectTab(tbp_cgd);
        }

        private void 采购订单ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_cgdd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_cgdd);
        }

        private void 销售单ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_xsd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_xsd);
        }

        private void 销售订单ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_xsdd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_xsdd);
        }

        private void 药品调拨ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_db.Parent = this.tbc;
            this.tbc.SelectTab(tbp_db);
        }

        private void 过期管理ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_pd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_pd);
        }

        private void 药品入库ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_rk.Parent = this.tbc;
            this.tbc.SelectTab(tbp_rk);
        }

        private void 付款单ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_fkd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_fkd);
        }

        private void 收款单ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_skd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_skd);
        }

        private void 供应商管理ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_gys.Parent = this.tbc;
            this.tbc.SelectTab(tbp_gys);
        }

        private void 仓库管理ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_ck.Parent = this.tbc;
            this.tbc.SelectTab(tbp_ck);
        }

        private void 药品管理ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_yp.Parent = this.tbc;
            this.tbc.SelectTab(tbp_yp);
        }

        private void 供应商类别ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_gyslb.Parent = this.tbc;
            this.tbc.SelectTab(tbp_gyslb);
        }

        private void 药品类别ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_ypzl.Parent = this.tbc;
            this.tbc.SelectTab(tbp_ypzl);
        }

        private void 计量单位ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_jldw.Parent = this.tbc;
            this.tbc.SelectTab(tbp_jldw);
        }

        private void 资金汇总ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbp_zjhz.Parent = this.tbc;
            this.tbc.SelectTab(tbp_zjhz);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.tbp_cgd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_cgd);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.tbp_xsd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_xsd);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.tbp_db.Parent = this.tbc;
            this.tbc.SelectTab(tbp_db);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.tbp_pd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_pd);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            this.tbp_rk.Parent = this.tbc;
            this.tbc.SelectTab(tbp_rk);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            this.tbp_zjhz.Parent = this.tbc;
            this.tbc.SelectTab(tbp_zjhz);
        }

        private void button7_Click(object sender, EventArgs e)
        {
            this.tbp_pd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_pd);
        }

        private void button8_Click(object sender, EventArgs e)
        {
            this.tbp_xsdd.Parent = this.tbc;
            this.tbc.SelectTab(tbp_xsdd);
        }

        private void button9_Click(object sender, EventArgs e)
        {
            this.tbp_yp.Parent = this.tbc;
            this.tbc.SelectTab(tbp_yp);
        }

        private void button10_Click(object sender, EventArgs e)
        {
            this.tbp_gyslb.Parent = this.tbc;
            this.tbc.SelectTab(tbp_gyslb);
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            Role role = new Role();
            role.ShowDialog();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            this.tbp_zjhz.Parent = this.tbc;
            this.tbc.SelectTab(tbp_zjhz);
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            this.tbp_ck.Parent = this.tbc;
            this.tbc.SelectTab(tbp_ck);
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            Addrole addrole = new Addrole();
            addrole.ShowDialog();
        }

        private void 关闭ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.tbc.SelectedTab.Parent = null;
        }

    }
}
