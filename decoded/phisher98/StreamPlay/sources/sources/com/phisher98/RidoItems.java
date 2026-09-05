package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/phisher98/RidoItems;", "", "slug", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "contentable", "Lcom/phisher98/RidoContentable;", "<init>", "(Ljava/lang/String;Lcom/phisher98/RidoContentable;)V", "getSlug", "()Ljava/lang/String;", "setSlug", "(Ljava/lang/String;)V", "getContentable", "()Lcom/phisher98/RidoContentable;", "setContentable", "(Lcom/phisher98/RidoContentable;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class RidoItems {

    @Nullable
    private RidoContentable contentable;

    @Nullable
    private String slug;

    /* JADX WARN: Multi-variable type inference failed */
    public RidoItems() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RidoItems copy$default(RidoItems ridoItems, String str, RidoContentable ridoContentable, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ridoItems.slug;
        }
        if ((i & 2) != 0) {
            ridoContentable = ridoItems.contentable;
        }
        return ridoItems.copy(str, ridoContentable);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RidoContentable getContentable() {
        return this.contentable;
    }

    @NotNull
    public final RidoItems copy(@JsonProperty("slug") @Nullable String slug, @JsonProperty("contentable") @Nullable RidoContentable contentable) {
        return new RidoItems(slug, contentable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RidoItems)) {
            return false;
        }
        RidoItems ridoItems = (RidoItems) other;
        return Intrinsics.areEqual(this.slug, ridoItems.slug) && Intrinsics.areEqual(this.contentable, ridoItems.contentable);
    }

    public int hashCode() {
        return ((this.slug == null ? 0 : this.slug.hashCode()) * 31) + (this.contentable != null ? this.contentable.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RidoItems(slug=" + this.slug + ", contentable=" + this.contentable + ')';
    }

    public RidoItems(@JsonProperty("slug") @Nullable String slug, @JsonProperty("contentable") @Nullable RidoContentable contentable) {
        this.slug = slug;
        this.contentable = contentable;
    }

    public /* synthetic */ RidoItems(String str, RidoContentable ridoContentable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : ridoContentable);
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    public final void setSlug(@Nullable String str) {
        this.slug = str;
    }

    @Nullable
    public final RidoContentable getContentable() {
        return this.contentable;
    }

    public final void setContentable(@Nullable RidoContentable ridoContentable) {
        this.contentable = ridoContentable;
    }
}
