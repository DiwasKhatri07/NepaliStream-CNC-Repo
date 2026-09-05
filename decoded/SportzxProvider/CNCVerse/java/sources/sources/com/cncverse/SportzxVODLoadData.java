package com.cncverse;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SportzxProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/cncverse/SportzxVODLoadData;", "", "id", "", "title", "poster", "cat", "formats", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getTitle", "getPoster", "getCat", "getFormats", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SportzxVODLoadData {

    @Nullable
    private final String cat;

    @NotNull
    private final List<String> formats;

    @NotNull
    private final String id;

    @Nullable
    private final String poster;

    @NotNull
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SportzxVODLoadData copy$default(SportzxVODLoadData sportzxVODLoadData, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sportzxVODLoadData.id;
        }
        if ((i & 2) != 0) {
            str2 = sportzxVODLoadData.title;
        }
        if ((i & 4) != 0) {
            str3 = sportzxVODLoadData.poster;
        }
        if ((i & 8) != 0) {
            str4 = sportzxVODLoadData.cat;
        }
        if ((i & 16) != 0) {
            list = sportzxVODLoadData.formats;
        }
        List list2 = list;
        String str5 = str3;
        return sportzxVODLoadData.copy(str, str2, str5, str4, list2);
    }

    @NotNull
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
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCat() {
        return this.cat;
    }

    @NotNull
    public final List<String> component5() {
        return this.formats;
    }

    @NotNull
    public final SportzxVODLoadData copy(@NotNull String id, @NotNull String title, @Nullable String poster, @Nullable String cat, @NotNull List<String> formats) {
        return new SportzxVODLoadData(id, title, poster, cat, formats);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportzxVODLoadData)) {
            return false;
        }
        SportzxVODLoadData sportzxVODLoadData = (SportzxVODLoadData) other;
        return Intrinsics.areEqual(this.id, sportzxVODLoadData.id) && Intrinsics.areEqual(this.title, sportzxVODLoadData.title) && Intrinsics.areEqual(this.poster, sportzxVODLoadData.poster) && Intrinsics.areEqual(this.cat, sportzxVODLoadData.cat) && Intrinsics.areEqual(this.formats, sportzxVODLoadData.formats);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.cat != null ? this.cat.hashCode() : 0)) * 31) + this.formats.hashCode();
    }

    @NotNull
    public String toString() {
        return "SportzxVODLoadData(id=" + this.id + ", title=" + this.title + ", poster=" + this.poster + ", cat=" + this.cat + ", formats=" + this.formats + ')';
    }

    public SportzxVODLoadData(@NotNull String id, @NotNull String title, @Nullable String poster, @Nullable String cat, @NotNull List<String> list) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.cat = cat;
        this.formats = list;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    public final String getCat() {
        return this.cat;
    }

    @NotNull
    public final List<String> getFormats() {
        return this.formats;
    }
}
