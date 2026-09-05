package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003J\u0083\u0001\u0010\u0018\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/phisher98/AllMovielandServer;", "", "title", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "id", "file", "folder", "Ljava/util/ArrayList;", "Lcom/phisher98/AllMovielandSeasonFolder;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getTitle", "()Ljava/lang/String;", "getId", "getFile", "getFolder", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AllMovielandServer {

    @Nullable
    private final String file;

    @Nullable
    private final ArrayList<AllMovielandSeasonFolder> folder;

    @Nullable
    private final String id;

    @Nullable
    private final String title;

    public AllMovielandServer() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AllMovielandServer copy$default(AllMovielandServer allMovielandServer, String str, String str2, String str3, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = allMovielandServer.title;
        }
        if ((i & 2) != 0) {
            str2 = allMovielandServer.id;
        }
        if ((i & 4) != 0) {
            str3 = allMovielandServer.file;
        }
        if ((i & 8) != 0) {
            arrayList = allMovielandServer.folder;
        }
        return allMovielandServer.copy(str, str2, str3, arrayList);
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

    @Nullable
    public final ArrayList<AllMovielandSeasonFolder> component4() {
        return this.folder;
    }

    @NotNull
    public final AllMovielandServer copy(@JsonProperty("title") @Nullable String title, @JsonProperty("id") @Nullable String id, @JsonProperty("file") @Nullable String file, @JsonProperty("folder") @Nullable ArrayList<AllMovielandSeasonFolder> folder) {
        return new AllMovielandServer(title, id, file, folder);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AllMovielandServer)) {
            return false;
        }
        AllMovielandServer allMovielandServer = (AllMovielandServer) other;
        return Intrinsics.areEqual(this.title, allMovielandServer.title) && Intrinsics.areEqual(this.id, allMovielandServer.id) && Intrinsics.areEqual(this.file, allMovielandServer.file) && Intrinsics.areEqual(this.folder, allMovielandServer.folder);
    }

    public int hashCode() {
        return ((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.file == null ? 0 : this.file.hashCode())) * 31) + (this.folder != null ? this.folder.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AllMovielandServer(title=" + this.title + ", id=" + this.id + ", file=" + this.file + ", folder=" + this.folder + ')';
    }

    public AllMovielandServer(@JsonProperty("title") @Nullable String title, @JsonProperty("id") @Nullable String id, @JsonProperty("file") @Nullable String file, @JsonProperty("folder") @Nullable ArrayList<AllMovielandSeasonFolder> arrayList) {
        this.title = title;
        this.id = id;
        this.file = file;
        this.folder = arrayList;
    }

    public /* synthetic */ AllMovielandServer(String str, String str2, String str3, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? new ArrayList() : arrayList);
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

    @Nullable
    public final ArrayList<AllMovielandSeasonFolder> getFolder() {
        return this.folder;
    }
}
