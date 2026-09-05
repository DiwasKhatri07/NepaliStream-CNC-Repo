package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/cncverse/SportzxCategoryData;", "", "id", "", "title", "image", "catLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getImage", "getCatLink", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SportzxCategoryData {

    @Nullable
    private final String catLink;

    @Nullable
    private final String id;

    @Nullable
    private final String image;

    @NotNull
    private final String title;

    public static /* synthetic */ SportzxCategoryData copy$default(SportzxCategoryData sportzxCategoryData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sportzxCategoryData.id;
        }
        if ((i & 2) != 0) {
            str2 = sportzxCategoryData.title;
        }
        if ((i & 4) != 0) {
            str3 = sportzxCategoryData.image;
        }
        if ((i & 8) != 0) {
            str4 = sportzxCategoryData.catLink;
        }
        return sportzxCategoryData.copy(str, str2, str3, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCatLink() {
        return this.catLink;
    }

    @NotNull
    public final SportzxCategoryData copy(@Nullable String id, @NotNull String title, @Nullable String image, @Nullable String catLink) {
        return new SportzxCategoryData(id, title, image, catLink);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportzxCategoryData)) {
            return false;
        }
        SportzxCategoryData sportzxCategoryData = (SportzxCategoryData) other;
        return Intrinsics.areEqual(this.id, sportzxCategoryData.id) && Intrinsics.areEqual(this.title, sportzxCategoryData.title) && Intrinsics.areEqual(this.image, sportzxCategoryData.image) && Intrinsics.areEqual(this.catLink, sportzxCategoryData.catLink);
    }

    public int hashCode() {
        return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + this.title.hashCode()) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.catLink != null ? this.catLink.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SportzxCategoryData(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", catLink=" + this.catLink + ')';
    }

    public SportzxCategoryData(@Nullable String id, @NotNull String title, @Nullable String image, @Nullable String catLink) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.catLink = catLink;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getCatLink() {
        return this.catLink;
    }
}
