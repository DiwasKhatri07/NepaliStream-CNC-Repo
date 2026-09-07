package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0019"}, d2 = {"Lcom/AniVortex/OttPlatform;", "", "slug", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "logoUrl", "logo_url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSlug", "()Ljava/lang/String;", "getName", "getLogoUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class OttPlatform {

    @JsonProperty("logo_url")
    @Nullable
    private final String logoUrl;

    @JsonProperty("name")
    @Nullable
    private final String name;

    @JsonProperty("slug")
    @Nullable
    private final String slug;

    public OttPlatform() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ OttPlatform copy$default(OttPlatform ottPlatform, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ottPlatform.slug;
        }
        if ((i & 2) != 0) {
            str2 = ottPlatform.name;
        }
        if ((i & 4) != 0) {
            str3 = ottPlatform.logoUrl;
        }
        return ottPlatform.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final OttPlatform copy(@JsonProperty("slug") @Nullable String slug, @JsonProperty("name") @Nullable String name, @JsonProperty("logo_url") @Nullable String logoUrl) {
        return new OttPlatform(slug, name, logoUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OttPlatform)) {
            return false;
        }
        OttPlatform ottPlatform = (OttPlatform) other;
        return Intrinsics.areEqual(this.slug, ottPlatform.slug) && Intrinsics.areEqual(this.name, ottPlatform.name) && Intrinsics.areEqual(this.logoUrl, ottPlatform.logoUrl);
    }

    public int hashCode() {
        return ((((this.slug == null ? 0 : this.slug.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.logoUrl != null ? this.logoUrl.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OttPlatform(slug=" + this.slug + ", name=" + this.name + ", logoUrl=" + this.logoUrl + ')';
    }

    public OttPlatform(@JsonProperty("slug") @Nullable String slug, @JsonProperty("name") @Nullable String name, @JsonProperty("logo_url") @Nullable String logoUrl) {
        this.slug = slug;
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public /* synthetic */ OttPlatform(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getLogoUrl() {
        return this.logoUrl;
    }
}
