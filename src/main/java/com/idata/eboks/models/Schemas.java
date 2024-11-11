package com.idata.eboks.models;

public class Schemas {
    private UserList userList;
    private Tenant tenant;
    private CompanyID companyID;
    private File file;
    private GetTenantRequest getTenantRequest;
    private Payment payment;
    private ContentUser contentUser;
    private UserMatch userMatch;
    private Icon icon;
    private RequestAccess requestAccess;

    public UserList getUserList() { 
        return userList; 
    }

    public void setUserList(UserList value) { 
        this.userList = value; 
    }

    public Tenant getTenant() { 
        return tenant; 
    }

    public void setTenant(Tenant value) { 
        this.tenant = value; 
    }

    public CompanyID getCompanyID() { 
        return companyID; 
    }

    public void setCompanyID(CompanyID value) {
        this.companyID = value; 
    }

    public File getFile() { 
        return file; 
    }

    public void setFile(File value) {
        this.file = value; 
    }

    public GetTenantRequest getGetTenantRequest() { 
        return getTenantRequest; 
    }

    public void setGetTenantRequest(GetTenantRequest value) { 
        this.getTenantRequest = value; 
    }

    public Payment getPayment() {
        return payment; 
    }

    public void setPayment(Payment value) { 
        this.payment = value; 
    }

    public ContentUser getContentUser() { 
        return contentUser; 
    }

    public void setContentUser(ContentUser value) { 
        this.contentUser = value; 
    }

    public UserMatch getUserMatch() {
        return userMatch; 
    }

    public void setUserMatch(UserMatch value) { 
        this.userMatch = value; 
    }

    public Icon getIcon() { 
        return icon; 
    }

    public void setIcon(Icon value) { 
        this.icon = value; 
    }

    public RequestAccess getRequestAccess() { 
        return requestAccess; 
    }

    public void setRequestAccess(RequestAccess value) { 
        this.requestAccess = value; 
    }
    
}
