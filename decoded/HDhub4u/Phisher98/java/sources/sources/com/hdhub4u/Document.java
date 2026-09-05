package com.hdhub4u;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDhub4u/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0016\b\u0001\u0010\r\u001a\u00020\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0016\b\u0001\u0010\u0011\u001a\u00020\u0012:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0012HÆ\u0003J¥\u0001\u0010)\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0016\b\u0003\u0010\u0007\u001a\u00020\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u000f\u001a\u00020\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u00102\u0016\b\u0003\u0010\u0011\u001a\u00020\u0012:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013HÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/hdhub4u/Document;", "", "category", "", "", "id", "permalink", "postDate", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "post_date", "postThumbnail", "post_thumbnail", "postTitle", "post_title", "postType", "post_type", "sortByDate", "", "sort_by_date", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCategory", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getPermalink", "getPostDate", "getPostThumbnail", "getPostTitle", "getPostType", "getSortByDate", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Document {

    @NotNull
    private final List<String> category;

    @NotNull
    private final String id;

    @NotNull
    private final String permalink;

    @NotNull
    private final String postDate;

    @NotNull
    private final String postThumbnail;

    @NotNull
    private final String postTitle;

    @NotNull
    private final String postType;
    private final long sortByDate;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Document copy$default(Document document, List list, String str, String str2, String str3, String str4, String str5, String str6, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = document.category;
        }
        if ((i & 2) != 0) {
            str = document.id;
        }
        if ((i & 4) != 0) {
            str2 = document.permalink;
        }
        if ((i & 8) != 0) {
            str3 = document.postDate;
        }
        if ((i & 16) != 0) {
            str4 = document.postThumbnail;
        }
        if ((i & 32) != 0) {
            str5 = document.postTitle;
        }
        if ((i & 64) != 0) {
            str6 = document.postType;
        }
        if ((i & 128) != 0) {
            j = document.sortByDate;
        }
        long j2 = j;
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        String str10 = str2;
        return document.copy(list, str, str10, str3, str9, str7, str8, j2);
    }

    @NotNull
    public final List<String> component1() {
        return this.category;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPermalink() {
        return this.permalink;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPostDate() {
        return this.postDate;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPostThumbnail() {
        return this.postThumbnail;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPostTitle() {
        return this.postTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPostType() {
        return this.postType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getSortByDate() {
        return this.sortByDate;
    }

    @NotNull
    public final Document copy(@NotNull List<String> category, @NotNull String id, @NotNull String permalink, @JsonProperty("post_date") @NotNull String postDate, @JsonProperty("post_thumbnail") @NotNull String postThumbnail, @JsonProperty("post_title") @NotNull String postTitle, @JsonProperty("post_type") @NotNull String postType, @JsonProperty("sort_by_date") long sortByDate) {
        return new Document(category, id, permalink, postDate, postThumbnail, postTitle, postType, sortByDate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Document)) {
            return false;
        }
        Document document = (Document) other;
        return Intrinsics.areEqual(this.category, document.category) && Intrinsics.areEqual(this.id, document.id) && Intrinsics.areEqual(this.permalink, document.permalink) && Intrinsics.areEqual(this.postDate, document.postDate) && Intrinsics.areEqual(this.postThumbnail, document.postThumbnail) && Intrinsics.areEqual(this.postTitle, document.postTitle) && Intrinsics.areEqual(this.postType, document.postType) && this.sortByDate == document.sortByDate;
    }

    public int hashCode() {
        return (((((((((((((this.category.hashCode() * 31) + this.id.hashCode()) * 31) + this.permalink.hashCode()) * 31) + this.postDate.hashCode()) * 31) + this.postThumbnail.hashCode()) * 31) + this.postTitle.hashCode()) * 31) + this.postType.hashCode()) * 31) + Document$$ExternalSyntheticBackport0.m0m(this.sortByDate);
    }

    @NotNull
    public String toString() {
        return "Document(category=" + this.category + ", id=" + this.id + ", permalink=" + this.permalink + ", postDate=" + this.postDate + ", postThumbnail=" + this.postThumbnail + ", postTitle=" + this.postTitle + ", postType=" + this.postType + ", sortByDate=" + this.sortByDate + ')';
    }

    public Document(@NotNull List<String> list, @NotNull String id, @NotNull String permalink, @JsonProperty("post_date") @NotNull String postDate, @JsonProperty("post_thumbnail") @NotNull String postThumbnail, @JsonProperty("post_title") @NotNull String postTitle, @JsonProperty("post_type") @NotNull String postType, @JsonProperty("sort_by_date") long sortByDate) {
        this.category = list;
        this.id = id;
        this.permalink = permalink;
        this.postDate = postDate;
        this.postThumbnail = postThumbnail;
        this.postTitle = postTitle;
        this.postType = postType;
        this.sortByDate = sortByDate;
    }

    @NotNull
    public final List<String> getCategory() {
        return this.category;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getPermalink() {
        return this.permalink;
    }

    @NotNull
    public final String getPostDate() {
        return this.postDate;
    }

    @NotNull
    public final String getPostThumbnail() {
        return this.postThumbnail;
    }

    @NotNull
    public final String getPostTitle() {
        return this.postTitle;
    }

    @NotNull
    public final String getPostType() {
        return this.postType;
    }

    public final long getSortByDate() {
        return this.sortByDate;
    }
}
