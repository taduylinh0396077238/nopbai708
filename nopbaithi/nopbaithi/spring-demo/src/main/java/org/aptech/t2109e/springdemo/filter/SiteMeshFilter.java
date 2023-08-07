package org.aptech.t2109e.springdemo.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/common/navbar.jsp")
                .addExcludedPath("/login")
                .addExcludedPath("/passwordChange");
    }
}
