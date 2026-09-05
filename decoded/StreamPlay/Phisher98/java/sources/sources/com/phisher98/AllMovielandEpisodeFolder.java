package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/phisher98/AllMovielandEpisodeFolder;", "", "title", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "id", "file", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "getFile", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AllMovielandEpisodeFolder {

    @Nullable
    private final String file;

    @Nullable
    private final String id;

    @Nullable
    private final String title;

    public AllMovielandEpisodeFolder() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AllMovielandEpisodeFolder copy$default(AllMovielandEpisodeFolder allMovielandEpisodeFolder, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = allMovielandEpisodeFolder.title;
        }
        if ((i & 2) != 0) {
            str2 = allMovielandEpisodeFolder.id;
        }
        if ((i & 4) != 0) {
            str3 = allMovielandEpisodeFolder.file;
        }
        return allMovielandEpisodeFolder.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    @NotNull
    public final AllMovielandEpisodeFolder copy(@JsonProperty("title") @Nullable String title, @JsonProperty("id") @Nullable String id, @JsonProperty("file") @Nullable String file) {
        return new AllMovielandEpisodeFolder(title, id, file);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AllMovielandEpisodeFolder)) {
            return false;
        }
        AllMovielandEpisodeFolder allMovielandEpisodeFolder = (AllMovielandEpisodeFolder) other;
        return Intrinsics.areEqual(this.title, allMovielandEpisodeFolder.title) && Intrinsics.areEqual(this.id, allMovielandEpisodeFolder.id) && Intrinsics.areEqual(this.file, allMovielandEpisodeFolder.file);
    }

    public int hashCode() {
        return ((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.file != null ? this.file.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AllMovielandEpisodeFolder(title=" + this.title + ", id=" + this.id + ", file=" + this.file + ')';
    }

    public AllMovielandEpisodeFolder(@JsonProperty("title") @Nullable String title, @JsonProperty("id") @Nullable String id, @JsonProperty("file") @Nullable String file) {
        this.title = title;
        this.id = id;
        this.file = file;
    }

    public /* synthetic */ AllMovielandEpisodeFolder(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getFile() {
        return this.file;
    }
}
