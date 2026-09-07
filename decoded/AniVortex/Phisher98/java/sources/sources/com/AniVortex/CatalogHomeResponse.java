package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JC\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR-\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/AniVortex/CatalogHomeResponse;", "", "catalog", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "sections", "", "Lcom/AniVortex/CatalogSection;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getCatalog", "()Ljava/lang/String;", "getSections", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class CatalogHomeResponse {

    @JsonProperty("catalog")
    @Nullable
    private final String catalog;

    @JsonProperty("sections")
    @Nullable
    private final List<CatalogSection> sections;

    /* JADX WARN: Multi-variable type inference failed */
    public CatalogHomeResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CatalogHomeResponse copy$default(CatalogHomeResponse catalogHomeResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = catalogHomeResponse.catalog;
        }
        if ((i & 2) != 0) {
            list = catalogHomeResponse.sections;
        }
        return catalogHomeResponse.copy(str, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCatalog() {
        return this.catalog;
    }

    @Nullable
    public final List<CatalogSection> component2() {
        return this.sections;
    }

    @NotNull
    public final CatalogHomeResponse copy(@JsonProperty("catalog") @Nullable String catalog, @JsonProperty("sections") @Nullable List<CatalogSection> sections) {
        return new CatalogHomeResponse(catalog, sections);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CatalogHomeResponse)) {
            return false;
        }
        CatalogHomeResponse catalogHomeResponse = (CatalogHomeResponse) other;
        return Intrinsics.areEqual(this.catalog, catalogHomeResponse.catalog) && Intrinsics.areEqual(this.sections, catalogHomeResponse.sections);
    }

    public int hashCode() {
        return ((this.catalog == null ? 0 : this.catalog.hashCode()) * 31) + (this.sections != null ? this.sections.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CatalogHomeResponse(catalog=" + this.catalog + ", sections=" + this.sections + ')';
    }

    public CatalogHomeResponse(@JsonProperty("catalog") @Nullable String catalog, @JsonProperty("sections") @Nullable List<CatalogSection> list) {
        this.catalog = catalog;
        this.sections = list;
    }

    public /* synthetic */ CatalogHomeResponse(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }

    @Nullable
    public final String getCatalog() {
        return this.catalog;
    }

    @Nullable
    public final List<CatalogSection> getSections() {
        return this.sections;
    }
}
