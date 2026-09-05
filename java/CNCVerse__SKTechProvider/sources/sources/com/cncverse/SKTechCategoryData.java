package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SKTechProvider/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003JF\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/cncverse/SKTechCategoryData;", "", "visible", "", "name", "", "logo", "type", "api", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "()Ljava/lang/String;", "getLogo", "getType", "getApi", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/SKTechCategoryData;", "equals", "other", "hashCode", "", "toString", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SKTechCategoryData {

    @NotNull
    private final String api;

    @Nullable
    private final String logo;

    @NotNull
    private final String name;

    @Nullable
    private final String type;

    @Nullable
    private final Boolean visible;

    public static /* synthetic */ SKTechCategoryData copy$default(SKTechCategoryData sKTechCategoryData, Boolean bool, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = sKTechCategoryData.visible;
        }
        if ((i & 2) != 0) {
            str = sKTechCategoryData.name;
        }
        if ((i & 4) != 0) {
            str2 = sKTechCategoryData.logo;
        }
        if ((i & 8) != 0) {
            str3 = sKTechCategoryData.type;
        }
        if ((i & 16) != 0) {
            str4 = sKTechCategoryData.api;
        }
        String str5 = str4;
        String str6 = str2;
        return sKTechCategoryData.copy(bool, str, str6, str3, str5);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getVisible() {
        return this.visible;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    @NotNull
    public final SKTechCategoryData copy(@Nullable Boolean visible, @NotNull String name, @Nullable String logo, @Nullable String type, @NotNull String api) {
        return new SKTechCategoryData(visible, name, logo, type, api);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SKTechCategoryData)) {
            return false;
        }
        SKTechCategoryData sKTechCategoryData = (SKTechCategoryData) other;
        return Intrinsics.areEqual(this.visible, sKTechCategoryData.visible) && Intrinsics.areEqual(this.name, sKTechCategoryData.name) && Intrinsics.areEqual(this.logo, sKTechCategoryData.logo) && Intrinsics.areEqual(this.type, sKTechCategoryData.type) && Intrinsics.areEqual(this.api, sKTechCategoryData.api);
    }

    public int hashCode() {
        return ((((((((this.visible == null ? 0 : this.visible.hashCode()) * 31) + this.name.hashCode()) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0)) * 31) + this.api.hashCode();
    }

    @NotNull
    public String toString() {
        return "SKTechCategoryData(visible=" + this.visible + ", name=" + this.name + ", logo=" + this.logo + ", type=" + this.type + ", api=" + this.api + ')';
    }

    public SKTechCategoryData(@Nullable Boolean visible, @NotNull String name, @Nullable String logo, @Nullable String type, @NotNull String api) {
        this.visible = visible;
        this.name = name;
        this.logo = logo;
        this.type = type;
        this.api = api;
    }

    @Nullable
    public final Boolean getVisible() {
        return this.visible;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getApi() {
        return this.api;
    }
}
