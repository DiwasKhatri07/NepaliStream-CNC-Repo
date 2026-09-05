package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/phisher98/VegamoviesDocument;", "", "id", "", "imdb_id", "permalink", "post_title", "post_thumbnail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getImdb_id", "getPermalink", "getPost_title", "getPost_thumbnail", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VegamoviesDocument {

    @Nullable
    private final String id;

    @Nullable
    private final String imdb_id;

    @Nullable
    private final String permalink;

    @Nullable
    private final String post_thumbnail;

    @Nullable
    private final String post_title;

    public static /* synthetic */ VegamoviesDocument copy$default(VegamoviesDocument vegamoviesDocument, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vegamoviesDocument.id;
        }
        if ((i & 2) != 0) {
            str2 = vegamoviesDocument.imdb_id;
        }
        if ((i & 4) != 0) {
            str3 = vegamoviesDocument.permalink;
        }
        if ((i & 8) != 0) {
            str4 = vegamoviesDocument.post_title;
        }
        if ((i & 16) != 0) {
            str5 = vegamoviesDocument.post_thumbnail;
        }
        String str6 = str5;
        String str7 = str3;
        return vegamoviesDocument.copy(str, str2, str7, str4, str6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPermalink() {
        return this.permalink;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPost_title() {
        return this.post_title;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPost_thumbnail() {
        return this.post_thumbnail;
    }

    @NotNull
    public final VegamoviesDocument copy(@Nullable String id, @Nullable String imdb_id, @Nullable String permalink, @Nullable String post_title, @Nullable String post_thumbnail) {
        return new VegamoviesDocument(id, imdb_id, permalink, post_title, post_thumbnail);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VegamoviesDocument)) {
            return false;
        }
        VegamoviesDocument vegamoviesDocument = (VegamoviesDocument) other;
        return Intrinsics.areEqual(this.id, vegamoviesDocument.id) && Intrinsics.areEqual(this.imdb_id, vegamoviesDocument.imdb_id) && Intrinsics.areEqual(this.permalink, vegamoviesDocument.permalink) && Intrinsics.areEqual(this.post_title, vegamoviesDocument.post_title) && Intrinsics.areEqual(this.post_thumbnail, vegamoviesDocument.post_thumbnail);
    }

    public int hashCode() {
        return ((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.permalink == null ? 0 : this.permalink.hashCode())) * 31) + (this.post_title == null ? 0 : this.post_title.hashCode())) * 31) + (this.post_thumbnail != null ? this.post_thumbnail.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VegamoviesDocument(id=" + this.id + ", imdb_id=" + this.imdb_id + ", permalink=" + this.permalink + ", post_title=" + this.post_title + ", post_thumbnail=" + this.post_thumbnail + ')';
    }

    public VegamoviesDocument(@Nullable String id, @Nullable String imdb_id, @Nullable String permalink, @Nullable String post_title, @Nullable String post_thumbnail) {
        this.id = id;
        this.imdb_id = imdb_id;
        this.permalink = permalink;
        this.post_title = post_title;
        this.post_thumbnail = post_thumbnail;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    public final String getPermalink() {
        return this.permalink;
    }

    @Nullable
    public final String getPost_title() {
        return this.post_title;
    }

    @Nullable
    public final String getPost_thumbnail() {
        return this.post_thumbnail;
    }
}
