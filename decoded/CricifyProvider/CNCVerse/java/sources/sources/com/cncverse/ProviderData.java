package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CricifyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/cncverse/ProviderData;", "", "id", "", "title", "", "image", "catLink", "type", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getImage", "getCatLink", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ProviderData {

    @Nullable
    private final String catLink;
    private final int id;

    @NotNull
    private final String image;

    @NotNull
    private final String title;

    @Nullable
    private final String type;

    public static /* synthetic */ ProviderData copy$default(ProviderData providerData, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = providerData.id;
        }
        if ((i2 & 2) != 0) {
            str = providerData.title;
        }
        if ((i2 & 4) != 0) {
            str2 = providerData.image;
        }
        if ((i2 & 8) != 0) {
            str3 = providerData.catLink;
        }
        if ((i2 & 16) != 0) {
            str4 = providerData.type;
        }
        String str5 = str4;
        String str6 = str2;
        return providerData.copy(i, str, str6, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCatLink() {
        return this.catLink;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final ProviderData copy(int id, @NotNull String title, @NotNull String image, @Nullable String catLink, @Nullable String type) {
        return new ProviderData(id, title, image, catLink, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProviderData)) {
            return false;
        }
        ProviderData providerData = (ProviderData) other;
        return this.id == providerData.id && Intrinsics.areEqual(this.title, providerData.title) && Intrinsics.areEqual(this.image, providerData.image) && Intrinsics.areEqual(this.catLink, providerData.catLink) && Intrinsics.areEqual(this.type, providerData.type);
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.title.hashCode()) * 31) + this.image.hashCode()) * 31) + (this.catLink == null ? 0 : this.catLink.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ProviderData(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", catLink=" + this.catLink + ", type=" + this.type + ')';
    }

    public ProviderData(int id, @NotNull String title, @NotNull String image, @Nullable String catLink, @Nullable String type) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.catLink = catLink;
        this.type = type;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ProviderData(int i, String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        String str5;
        if ((i2 & 16) == 0) {
            str5 = str4;
        } else {
            str5 = null;
        }
        this(i, str, str2, str3, str5);
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getCatLink() {
        return this.catLink;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }
}
