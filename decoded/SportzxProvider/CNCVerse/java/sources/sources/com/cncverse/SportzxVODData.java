package com.cncverse;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/cncverse/SportzxVODData;", "", "id", "", "title", "image", "cat", "publish", "formats", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getTitle", "getImage", "getCat", "getPublish", "getFormats", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SportzxVODData {

    @Nullable
    private final String cat;

    @Nullable
    private final List<String> formats;

    @Nullable
    private final String id;

    @Nullable
    private final String image;

    @Nullable
    private final String publish;

    @Nullable
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SportzxVODData copy$default(SportzxVODData sportzxVODData, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sportzxVODData.id;
        }
        if ((i & 2) != 0) {
            str2 = sportzxVODData.title;
        }
        if ((i & 4) != 0) {
            str3 = sportzxVODData.image;
        }
        if ((i & 8) != 0) {
            str4 = sportzxVODData.cat;
        }
        if ((i & 16) != 0) {
            str5 = sportzxVODData.publish;
        }
        if ((i & 32) != 0) {
            list = sportzxVODData.formats;
        }
        String str6 = str5;
        List list2 = list;
        return sportzxVODData.copy(str, str2, str3, str4, str6, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
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
    public final String getCat() {
        return this.cat;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPublish() {
        return this.publish;
    }

    @Nullable
    public final List<String> component6() {
        return this.formats;
    }

    @NotNull
    public final SportzxVODData copy(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String cat, @Nullable String publish, @Nullable List<String> formats) {
        return new SportzxVODData(id, title, image, cat, publish, formats);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportzxVODData)) {
            return false;
        }
        SportzxVODData sportzxVODData = (SportzxVODData) other;
        return Intrinsics.areEqual(this.id, sportzxVODData.id) && Intrinsics.areEqual(this.title, sportzxVODData.title) && Intrinsics.areEqual(this.image, sportzxVODData.image) && Intrinsics.areEqual(this.cat, sportzxVODData.cat) && Intrinsics.areEqual(this.publish, sportzxVODData.publish) && Intrinsics.areEqual(this.formats, sportzxVODData.formats);
    }

    public int hashCode() {
        return ((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.cat == null ? 0 : this.cat.hashCode())) * 31) + (this.publish == null ? 0 : this.publish.hashCode())) * 31) + (this.formats != null ? this.formats.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SportzxVODData(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", cat=" + this.cat + ", publish=" + this.publish + ", formats=" + this.formats + ')';
    }

    public SportzxVODData(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String cat, @Nullable String publish, @Nullable List<String> list) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.cat = cat;
        this.publish = publish;
        this.formats = list;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getCat() {
        return this.cat;
    }

    @Nullable
    public final String getPublish() {
        return this.publish;
    }

    @Nullable
    public final List<String> getFormats() {
        return this.formats;
    }
}
