package com.bst;

import java.util.Scanner;

class binarySearchTree{

	static class Node{
		int key;
		Node left, right;			
	}
// Method to create a new node
	static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}
// Method to insert the new node in BST
	static Node insert(Node root, int key) {

		Node newnode = newNode(key);
		Node x = root;
		Node y = null; // y maintains pointer to x

		while (x != null) {
			y = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}

		// If the root is null, the tree is empty.
		if (y == null)
			y = newnode;

		// assign new node node to the left child
		else if (key < y.key)
			y.left = newnode;

		// assign the new node to the right child
		else
			y.right = newnode;

		// return pointer to new node
		return y;
	}
	// Method to print the Inorder of BST
	static void Inorder(Node root) {
		if (root == null)
			return;
		else {
			Inorder(root.left);
			System.out.print(root.key + " ");
			Inorder(root.right);
		}
	}
	
// Method to find the pairs resulting the sum
	static void pair(int[] arr, int sum) {
		int temp = 0;
		for(int i = 0; i < arr.length ; i++) {

			for(int j = i+1 ; j < arr.length ; j++) {
				if((arr[i]+arr[j]) == sum) {
					temp++;
					if(temp==1) {
						System.out.print("Pairs resulting the sum = "+sum+" are: ("+arr[i]+","+arr[j]+")");
					}
					else {
						System.out.print(",("+arr[i]+","+arr[j]+")");
					}
				}
			}
		}
		if(temp==0) {
			System.out.print("no pair found resulting the sum");
		}
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int value, num;

		System.out.println("Enter total no. of values in BST: ");
		num = sc.nextInt();

		Node root = null;
		Node result = null;

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.println("\nInsert value at " + (i + 1) + ": ");
			value = sc.nextInt();
			arr[i] = value;
			if (root == null) {
				root = insert(root, value);
			} else {
				result = insert(root, value);
				if (result.key == value)
					i -= 1;
			}
			System.out.println("Inorder of BST\n");
			Inorder(root);
		}

		System.out.println("\nEnter sum to check pair: ");
		int sum = sc.nextInt();
		pair(arr, sum);

		sc.close();
	}
}